package com.employeeapp.controller;

import com.employeeapp.model.*;
import com.employeeapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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


    @GetMapping("/team_details/{id}")
    public String loadTeamDetails(@PathVariable Long id,Model model){
        Team teams = teamService.findById(id);
        model.addAttribute("teams",teams);
        return "";
    }
//line below ok
    @GetMapping("/assignTeam/{id}")
    public String assignTask(@PathVariable Long id,Model model){
        Role role2 = roleService.findById(2L);
        Role role3 = roleService.findById(3L);
        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("emp",employeeService.getEmployeeByRole(role2));
        model.addAttribute("emp2",employeeService.getEmployeeByRole(role3));
        return "/admin/team/assign_team";
    }
    @PostMapping("/addTeam")
    public String loadForm(@ModelAttribute("id") Long id, Team team){

        Task task = taskService.findById(id);
        team.setTask(task);
        team.setDate(new Date());

        teamService.save(team);
        return "redirect:/admin/manageTask";
    }

    @PostMapping("/assignTeam")
    public String assignTeam(@ModelAttribute("teamLead") Employee teamLead,
                             @ModelAttribute("id") Task id,
                             @ModelAttribute("temployee") List<Employee> temployee){

        TeamLead tl  = new TeamLead();
        tl.setEmployee(teamLead);
        //tl.setTask(id);

        Team team = new Team();
        team.setEmployee(temployee);
        team.setTask(id);
        team.setDate(new Date());
        teamService.save(team);

        tl.setTeam(team);



        teamLeadService.save(tl);


        return "redirect:/admin/manageTask";
    }
}
