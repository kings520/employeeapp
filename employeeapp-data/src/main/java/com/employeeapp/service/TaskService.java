package com.employeeapp.service;

import com.employeeapp.model.Employee;
import com.employeeapp.model.Task;

public interface TaskService extends CrudService<Task,Long> {
    Task findByTeamLead(Employee employee);
   // Long countEmployee(Task task);
}
