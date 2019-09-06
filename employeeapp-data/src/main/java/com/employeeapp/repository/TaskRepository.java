package com.employeeapp.repository;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    Task findByTeamLead(Employee employee);
    //Long countByEmployees(Task task);
}
