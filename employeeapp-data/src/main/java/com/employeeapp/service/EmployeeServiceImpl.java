package com.employeeapp.service;

import com.employeeapp.model.Employee;
import com.employeeapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @Override
//    public Optional<Employee> findByEmail(String email) {
//        return employeeRepository.findByEmail(email);
//    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees =  new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    @Override
    public Employee save(Employee object) {
        return employeeRepository.save(object);
    }

    @Override
    public Employee findById(Long aLong) {
        return employeeRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Employee object) {
        employeeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        employeeRepository.deleteById(aLong);
    }
}
