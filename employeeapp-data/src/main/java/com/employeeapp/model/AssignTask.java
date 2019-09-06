package com.employeeapp.model;

import java.util.Date;

public class AssignTask extends BaseEntity {
    private Date completionDate;
    private Date assignedDate;
    private String subTaskTitle;
    private String subTask;
    private Task task;
}
