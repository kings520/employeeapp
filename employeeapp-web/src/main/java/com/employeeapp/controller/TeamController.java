package com.employeeapp.controller;

import com.employeeapp.model.Employee;

import com.employeeapp.model.Team;
import com.employeeapp.model.TeamName;
import com.employeeapp.model.TeamRole;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.TeamNameService;
import com.employeeapp.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class TeamController {

    private final TeamService teamService;
    private final TeamNameService teamNameService;
    private final EmployeeService employeeService;

    public TeamController(TeamService teamService, TeamNameService teamNameService, EmployeeService employeeService) {
        this.teamService = teamService;
        this.teamNameService = teamNameService;
        this.employeeService = employeeService;

    }

    @GetMapping("/manageTeam")
    public String loadTeam(Model model){
        model.addAttribute("team",teamService.findAll());
       // model.addAttribute("teamName",teamNameService.findAll());
        //model.addAttribute("emp",employeeService.findAll());

        return "admin/team/list_team";
    }
    @GetMapping("/loadTeamForm")
    public String loadTeamForm(Model model){
       // model.addAttribute("team",teamService.findAll());
        model.addAttribute("teamName",teamNameService.findAll());
        model.addAttribute("emp",employeeService.findAll());
        return "admin/team/new_team";
    }
    @PostMapping("/addTeam")
    public String loadForm(@ModelAttribute Team team, BindingResult result){

       // Team team = new Team();
        team.setDate(new Date());
        //team.setTeamName(teamName);
        //team.setEmployee(employee);
       // team.setTeamRole(teamRole);

//        if(result.hasErrors()){
//            return "admin/team/new_team";
//        }
        teamService.save(team);
        return "redirect:/admin/manageTeam";
    }
}
