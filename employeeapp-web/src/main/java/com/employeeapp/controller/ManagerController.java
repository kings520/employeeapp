package com.employeeapp.controller;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Task;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.RoleService;
import com.employeeapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String viewTeam(@PathVariable Long id, Model model){
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

        return "/manager/team/detail_team";
    }

    @GetMapping("/viewTask/{id}")
    public String viewTask(@PathVariable Long id, Model model){
        model.addAttribute("task",taskService.findById(id));
        model.addAttribute("emp",employeeService.findAll());
        return "/manager/task/detail_task";
    }
}
