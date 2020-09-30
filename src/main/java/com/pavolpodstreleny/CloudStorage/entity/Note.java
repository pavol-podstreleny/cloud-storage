package com.pavolpodstreleny.CloudStorage.entity;

public class Note {

    private Integer id;
    private String title;
    private String description;
    private Integer userId;

    public Note(Integer id, String title, String description, Integer userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Note(String title, String description, Integer userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserid(Integer userId) {
        this.userId = userId;
    }
}