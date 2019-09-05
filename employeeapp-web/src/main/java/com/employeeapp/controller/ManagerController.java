package com.employeeapp.controller;

import com.employeeapp.model.Employee;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.RoleService;
import com.employeeapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/myTask")
    public String loadAllTask(Model model){
        Employee emp = employeeService.findById(2L);
        //List<Task> task = taskService.findAll();
        model.addAttribute("task",taskService.findByTeamLead(emp));
        return "manager/task/list_task";
    }

    @GetMapping("/viewTeam/{id}")
    public String viewTask(@PathVariable Long id, Model model){
        model.addAttribute("empCount",employeeService.countEmployee());
        model.addAttribute("emp",employeeService.findAll());
        model.addAttribute("task",taskService.findById(id));
        return "/admin/team/detail_team";
    }
}
