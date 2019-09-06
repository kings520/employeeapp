package com.employeeapp.repository;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Role;
import com.employeeapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByRole(Role role);
    List<Employee> findAllByRoleEquals(Role role);
    Long countEmployeeByTeam(Task task);
  // Optional<Employee> findByEmail(String email);
}
