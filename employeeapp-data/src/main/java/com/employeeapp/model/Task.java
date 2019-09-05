package com.employeeapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "task")
public class Task extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;

    @Column(name = "dateCreated")
    private Date createdDate;

    @Column(name = "endDate")
    private Date dueDate;

    @Column(name = "startDate")
    private Date startDate;
    //system only feteech names of managers

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamLead_id",referencedColumnName = "id")
    private Employee teamLead;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "task_team",joinColumns = @JoinColumn(name = "task_id"),inverseJoinColumns = @JoinColumn(name = "emp_id"))
    private List<Employee> employees;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public Employee getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Employee teamLead) {
        this.teamLead = teamLead;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
