package com.employeeapp.repository;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByRole(Role role);
    List<Employee> findAllByRoleEquals(Role role);
  // Optional<Employee> findByEmail(String email);
}
