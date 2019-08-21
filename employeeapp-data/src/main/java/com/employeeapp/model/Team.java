package com.employeeapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "employee_team",joinColumns = {@JoinColumn(name = "team_id")},inverseJoinColumns = {@JoinColumn(name = "emp_id")})
    private List<Employee> employee;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "team_name_id")
    private TeamName teamName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "team_role")
    private  TeamRole teamRole;

    @Column(name = "date_added")
    private Date date;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public TeamName getTeamName() {
        return teamName;
    }

    public void setTeamName(TeamName teamName) {
        this.teamName = teamName;
    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
