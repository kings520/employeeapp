package com.employeeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerHomeController {
    @GetMapping({"","/","/index","/dashboard","/index.html"})
    public String index(){
        return "manager/index";
    }

}
