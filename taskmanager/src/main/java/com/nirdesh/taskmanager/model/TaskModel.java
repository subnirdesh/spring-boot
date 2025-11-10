package com.nirdesh.taskmanager.model;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class TaskModel {
    private int id;
    private String name;
    private LocalDate  createdAt;
    private LocalDate completeAt;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Local getCompleteAt() {
        return completeAt;
    }

    public void setCompleteAt(Local completeAt) {
        this.completeAt = completeAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
