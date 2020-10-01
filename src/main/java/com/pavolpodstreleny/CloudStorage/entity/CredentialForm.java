package com.pavolpodstreleny.CloudStorage.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CredentialForm {

    private Integer id;

    @NotNull(message = "Url field can not be null")
    @NotEmpty(message = "Url field can not be empty")
    @Size(min = 3, max = 100, message = "Url can not be shorter than 3 characters and longer than 100 characters")
    private String url;

    @NotEmpty(message = "Username field can not be empty")
    @NotNull(message = "Username field can not be null")
    @Size(min = 3, max = 30, message = "Username can't be shorter than 3 character and longer than 30 characters")
    private String username;

    private String key;
    private String password;
    private Integer userId;

}
