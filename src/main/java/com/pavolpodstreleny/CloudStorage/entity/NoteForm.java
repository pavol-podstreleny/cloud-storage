package com.pavolpodstreleny.CloudStorage.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NoteForm {

    private Integer id;

    @NotNull(message = "Title can not be null")
    @NotEmpty(message = "Title can not be empty")
    @Size(min = 3, max = 20, message = "Title can not be shorther than 3 characters and longer than 20 characters.")
    private String title;

    @NotNull(message = "Description can not be null")
    @NotEmpty(message = "Description can not be empty")
    @Size(min = 3, max = 1000, message = "Description can not be shorther than 3 characters and longer than 1000 characters.")
    private String description;
    private Integer userId;

    public NoteForm() {

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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}