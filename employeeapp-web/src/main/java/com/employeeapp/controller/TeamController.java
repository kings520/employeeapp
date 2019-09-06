package com.employeeapp.controller;

import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import com.employeeapp.model.Team;
import com.employeeapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class TeamController {

    private final TeamService teamService;
    private final TeamLeadService teamLeadService;
    private final EmployeeService employeeService;
    private final TaskService taskService;

    @Autowired
    private RoleService roleService;

    public TeamController(TeamService teamService, TeamLeadService teamLeadService, EmployeeService employeeService,
                          TaskService taskService) {
        this.teamService = teamService;
        this.teamLeadService = teamLeadService;
        this.employeeService = employeeService;
        this.taskService = taskService;
    }

    @GetMapping("/manageTeam")
    public String loadTeam(Model model){
        Role role2 = roleService.findById(2L);
        model.addAttribute("team",teamService.findAll());
        model.addAttribute("emp",employeeService.getEmployeeByRole(role2));
        return "admin/team/list_team";
    }

//line below ok
    @GetMapping("/viewTeam/{id}")
    public String viewTeam(@PathVariable Long id,Model model){
        Task task = taskService.findById(id);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date currentDate = new Date();
        String dateToStr = format.format(currentDate);
        //String dateStart = new Date().toString();
        String dateStop = task.getDueDate().toString();

        Date d1 = null;
        Date d2 = null;

        try {
            d1 = format.parse(dateToStr);
            d2 = format.parse(dateStop);

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            model.addAttribute("diffDays",diffDays);
            model.addAttribute("diffHours",diffHours);
            model.addAttribute("diffMinutes",diffMinutes);
            model.addAttribute("diffSeconds",diffSeconds);
            model.addAttribute("empCount",employeeService.countEmployee(task));
            model.addAttribute("emp",employeeService.findAll());
            model.addAttribute("task",task);
//            System.out.print(diffDays + " days, ");
//            System.out.print(diffHours + " hours, ");
//            System.out.print(diffMinutes + " minutes, ");
//            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "/admin/team/detail_team";
    }
    @PostMapping("/addTeam")
    public String loadForm(@ModelAttribute("id") Long id, Team team){

        Task task = taskService.findById(id);
        team.setTask(task);
        team.setDate(new Date());

        teamService.save(team);
        return "redirect:/admin/manageTask";
    }


}
