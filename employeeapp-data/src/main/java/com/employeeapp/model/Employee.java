package com.employeeapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity {
    @Column(name = "firsName")
    private String FirstName;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "otherName")
    private String OtherName;

    @Column(name = "address")
    private String Address;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "email")
    private String Email;

    @Column(name = "dateofbirth")
    private Date DateOfBirth;

    @Column(name = "salary")
    private String Salary;

    @Column(name = "bank")
    private String Bank;

    @Column(name = "accountName")
    private String AccountName;

    @Column(name = "accountNumber")
    private String AccountNumber;

    @Column(name = "status")
    private String Status;

    @Column(name = "dateemployed")
    private Date DateEmployed;

//    @OneToOne(cascade =  CascadeType.ALL)
//////    @JoinColumn(name = "user_id", referencedColumnName = "id")
//////    private User user;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "employee_role",joinColumns = {@JoinColumn(name = "emp_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> role;

    @Column(name = "active")
    private int active;

    @ManyToMany(mappedBy = "employee")
    private List<Team> team;

//    @OneToOne(mappedBy = "employee")
//    private Task task;

    public Employee() {
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getOtherName() {
        return OtherName;
    }

    public void setOtherName(String otherName) {
        OtherName = otherName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getDateEmployed() {
        return DateEmployed;
    }

    public void setDateEmployed(Date dateEmployed) {
        DateEmployed = dateEmployed;
    }

//    public User getUser() {
////        return user;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Team> getTeam() {
        return team;
    }

    public void setTeam(List<Team> team) {
        this.team = team;
    }

//    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }
}
