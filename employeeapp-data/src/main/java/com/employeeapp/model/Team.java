package com.employeeapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "team_employee",joinColumns = {@JoinColumn(name = "emp_id")},inverseJoinColumns = @JoinColumn(name = "task_id"))
//    private List<Employee> employee;

    @Column(name = "date_added")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="task_id",referencedColumnName = "id")
    private Task task;

//    public List<Employee> getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(List<Employee> employee) {
//        this.employee = employee;
//    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
