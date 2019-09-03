package com.employeeapp.model;

import javax.persistence.*;

@Entity
@Table(name = "team_lead")
public class TeamLead extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="emp_id",referencedColumnName = "id")
    private Employee employee;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="task_id",referencedColumnName = "id")
//    private Task task;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id",referencedColumnName = "id")
    private Team team;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
