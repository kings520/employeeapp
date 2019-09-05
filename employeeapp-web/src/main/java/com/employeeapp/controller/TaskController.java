package com.employeeapp.controller;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.RoleService;
import com.employeeapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("task",task);
        return "admin/task/list_task";
    }

    @GetMapping("/newTask")
    public String newTask(Model model){
        Role role2 = roleService.findById(2L);
        Role role3 = roleService.findById(3L);
        model.addAttribute("emp",employeeService.getEmployeeByRole(role2));
        model.addAttribute("emp2",employeeService.getEmployeeByRole(role3));
        return "/admin/task/new_task";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam("title") String title,
                          @RequestParam("description") String description,
                          @RequestParam("dueDate") Date dueDate,
                          @RequestParam("status") String status,
                          @RequestParam("priority") String priority,
                          @RequestParam("startDate") Date startDate,
                          @RequestParam("teamLead") Employee teamLead,
                          @RequestParam("team") List<Employee> team){

        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStartDate(startDate);
        task.setDueDate(dueDate);
        task.setStatus(status);
        task.setPriority(priority);
        task.setCreatedDate(new Date());
        task.setTeamLead(teamLead);
        task.setEmployees(team);
        taskService.save(task);

        return "redirect:/admin/manageTask";
    }

    @GetMapping("/viewTask/{id}")
    public String viewTask(@PathVariable Long id, Model model){
        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("emp",employeeService.findAll());
        return "/admin/task/detail_task";
    }

}
