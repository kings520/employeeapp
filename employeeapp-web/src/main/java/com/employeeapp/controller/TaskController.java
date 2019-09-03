package com.employeeapp.controller;

import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.RoleService;
import com.employeeapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/manageTask")
    public String loadAllTask(Model model){
        List<Task> task = taskService.findAll();
        List<Role> role = roleService.findAll();
        Role role2 = roleService.findById(2L);
        model.addAttribute("task",task);
        model.addAttribute("role",role);
        model.addAttribute("emp",employeeService.getEmployeeByRole(role2));
        return "admin/task/list_task";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("dueDate") Date dueDate,
                          @RequestParam("status") String status,
                          @RequestParam("priority") String priority,
                          @RequestParam("startDate") Date startDate){

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setPriority(priority);
        task.setCreatedDate(new Date());
        taskService.save(task);

        return "redirect:/admin/manageTask";
    }

    @GetMapping("/newTask")
    public String newTask(Model model){

        Role role2 = roleService.findById(2L);
        Role role3 = roleService.findById(3L);
        //model.addAttribute("task",taskService.findById(id));
        model.addAttribute("emp",employeeService.getEmployeeByRole(role2));
        model.addAttribute("emp2",employeeService.getEmployeeByRole(role3));
        return "/admin/task/new_task";
    }
}
