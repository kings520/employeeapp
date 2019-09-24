package com.employeeapp.controller;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Role;
import com.employeeapp.service.EmployeeService;
import com.employeeapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

;
;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

    //@Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/manageEmployee")
    public String manageEmployee(Model model) {
        List<Employee> all = employeeService.findAll();
        model.addAttribute("employee", all);
        return "admin/employee/list_employee";
    }

    @GetMapping("/formEmployee")
    public String loadEmployeeForm(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("rr", roles);
        return "admin/employee/new_employee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "surname") String surname,
            @RequestParam(value = "otherName") String otherName,
            @RequestParam(value = "phone") String phone,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "dateofbirth") Date dateofbirth,
            @RequestParam(value = "address") String address,
            @RequestParam(value = "status") String status,
            @RequestParam(value = "dateemployed") Date dateemployed,
            @RequestParam(value = "salary") String salary,
            @RequestParam(value = "bank") String bank,
            @RequestParam(value = "accountName") String accountName,
            @RequestParam(value = "accountNumber") String accountNumber,
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "roleName") List<Role> roleName,
            @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/addEmployee";
        }
        employee.setFirstName(firstName);
        employee.setSurname(surname);
        employee.setOtherName(otherName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setDateOfBirth(dateofbirth);
        employee.setAddress(address);
        employee.setStatus(status);
        employee.setDateEmployed(dateemployed);
        employee.setSalary(salary);
        employee.setBank(bank);
        employee.setAccountName(accountName);
        employee.setAccountNumber(accountNumber);

        passwordEncoder = new BCryptPasswordEncoder();
        //String hashedPassword = passwordEncoder.encode(password);

        //User user = new User();
        employee.setActive(1);
        employee.setUsername(username);
        //user.setPassword(hashedPassword);
        employee.setPassword(passwordEncoder.encode(password));
        //employee.setEmployee(employee);
        employee.setRole(roleName);

        //employee.setUser(user);
        employeeService.save(employee);
       // userService.save(user);

        return "redirect:/admin/manageEmployee";
    }

    @GetMapping("/employeedetail/{id}")
    public String employeedetail(@PathVariable Long id, Model model){
        model.addAttribute("emp", employeeService.findById(id));
        return "admin/employee/detail_employee";
    }
    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        model.addAttribute("emp", employeeService.findById(id));
        return "admin/employee/edit_employee";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            employee.setId(id);
            return "admin/employee/edit_employee";
        }
        employeeService.save(employee);
        return "redirect:/admin/manageEmployee";
    }

    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
       Employee employee = employeeService.findById(id);
       employeeService.delete(employee);
        //System.out.println("User deletion respone: " + isDeleted);
        return "redirect:/admin/manageEmployee";
    }
}
