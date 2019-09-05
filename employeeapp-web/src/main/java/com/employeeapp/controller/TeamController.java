package com.employeeapp.controller;

import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import com.employeeapp.model.Team;
import com.employeeapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String viewTask(@PathVariable Long id,Model model){
        model.addAttribute("empCount",employeeService.countEmployee());
        model.addAttribute("emp",employeeService.findAll());
        model.addAttribute("task",taskService.findById(id));
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
