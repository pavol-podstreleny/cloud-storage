package com.pavolpodstreleny.CloudStorage.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
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

}