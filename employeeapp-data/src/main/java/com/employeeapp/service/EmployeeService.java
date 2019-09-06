package com.employeeapp.service;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Role;
import com.employeeapp.model.Task;

import java.util.List;

public interface EmployeeService extends CrudService<Employee,Long> {
   // Optional<Employee> findByEmail(String email);
   // List<Employee> getEmployeeByRole(Role role);

    List<Employee> getEmployeeByRole(Role role);
    Long countEmployee(Task task);
}
