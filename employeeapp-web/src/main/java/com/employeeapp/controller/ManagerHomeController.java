package com.employeeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerHomeController {
    @RequestMapping({"","/","/index","/index.html"})
    public String index(){
        return "manager/index";
    }

}
