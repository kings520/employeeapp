package com.employeeapp.controller;

import com.employeeapp.model.SubTask;
import com.employeeapp.model.Task;
import com.employeeapp.service.SubTaskService;
import com.employeeapp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/manager")
@Controller
public class SubTaskController {
    private SubTaskService taskService;
    private TaskService ts;

    public SubTaskController(SubTaskService taskService, TaskService ts) {
        this.taskService = taskService;
        this.ts = ts;
    }

    @GetMapping("/subTask/{id}")
    public String loadSubTaskForm(@PathVariable("id") Long id, Model model){
        Task task = ts.findById(id);
        model.addAttribute("task",task);
        model.addAttribute("subTask",taskService.findAll());
        return "manager/task/sub_task";
    }

    @PostMapping("/addTask")
    public String addSubTask(@RequestParam("title") String title,@RequestParam("description") String description,@RequestParam("task2") Task task2){
        SubTask subTask = new SubTask();
        subTask.setTitle(title);
        subTask.setDescription(description);
        subTask.setDateAdded(new Date());
        subTask.setTask(task2);
        taskService.save(subTask);
        return "redirect:/manager/subTask/"+task2.getId();
    }

    @GetMapping("/editSubTask/{id}")
    public String editSubTask(@PathVariable("id") Long id,Model model){
        SubTask subTask = taskService.findById(id);
        Task task = ts.findById(id);
        model.addAttribute("task",task);
        model.addAttribute("subTask",taskService.findAll());
        return "manager/task/sub_task";
    }
}
