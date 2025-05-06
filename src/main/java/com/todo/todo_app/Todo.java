package com.todo.todo_app;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "todos")

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "checked")
    private boolean checked;
    @Column(name = "title")
    private String title;
    @Column(name = "priority")
    private String priority;
    @Column(name = "deadline")
    private String deadline;
    @Column(name = "comments")
    private  String comments;


    public Todo(){}

    public Todo( boolean checked,Long id, String title, String priority,String deadline, String comments) {
        this.checked = checked;
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
        this.comments = comments;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
