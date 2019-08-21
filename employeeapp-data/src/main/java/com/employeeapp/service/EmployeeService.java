package com.employeeapp.service;

import com.employeeapp.model.Employee;

import java.util.Optional;

public interface EmployeeService extends CrudService<Employee,Long> {
   // Optional<Employee> findByEmail(String email);
}
