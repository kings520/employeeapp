package com.employeeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeHomeController {

    @RequestMapping({"","/","/index","/index.html"})
    public String index(){
        return "employee/index";
    }

}
