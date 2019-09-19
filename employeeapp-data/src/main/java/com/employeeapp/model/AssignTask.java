package com.employeeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "assign_task")
@Data
public class AssignTask extends BaseEntity {
    private Date completionDate;
    private Date assignedDate;
   // private Task task;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id",referencedColumnName = "id")
    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "subtask_id",referencedColumnName = "id")
    private SubTask subTask;
}
