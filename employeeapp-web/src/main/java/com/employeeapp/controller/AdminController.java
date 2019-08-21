package com.employeeapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by User-pc on 8/16/2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

//    private UserService userService;
//    private RoleService roleService;
//
//
//    public AdminController(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }

    //@PreAuthorize("hasAnyRole('Role_Admin')" )
    @RequestMapping({"","/","/index","dashboard","index.html"})
    public String index(){
        return "adminlayout";
    }

//    @RequestMapping("/login")
//    public ModelAndView home(@RequestParam("formauth") String formauth){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByUsername(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getEmployee().getFirstName() + " " + user.getEmployee().getSurname() );
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//
//        Role role = new Role();
//        role.setName(formauth);
//
//        if (role.getName()== user.getRole().toString()){
//
//        }
//        return modelAndView;
//    }
}