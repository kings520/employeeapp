package com.employeeapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sub_task")
public class SubTask extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;
    private String title;
    private String description;
    private Date dateAdded;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
