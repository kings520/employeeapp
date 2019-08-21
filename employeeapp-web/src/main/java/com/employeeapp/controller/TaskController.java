package com.employeeapp.controller;

import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import com.employeeapp.service.RoleService;
import com.employeeapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/manageTask")
    public String loadAllTask(Model model){
        List<Task> task = taskService.findAll();
        List<Role> role = roleService.findAll();
        model.addAttribute("task",task);
        model.addAttribute("role",role);
        return "admin/task/list_task";
    }
}
