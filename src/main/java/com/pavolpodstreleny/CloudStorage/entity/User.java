package com.pavolpodstreleny.CloudStorage.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {

    private Integer userId;
    private String salt;

    @NotEmpty(message = "First Name can not be empty.")
    @NotNull(message = "First Name can not be null.")
    @Size(min = 3, message = "First Name must contain at least 3 characters.")
    private String firstName;

    @NotEmpty(message = "Last Name can not be empty.")
    @NotNull(message = "Last Name can not be null.")
    @Size(min = 3, message = "Last Name must contain at least 3 characters.")
    private String lastName;

    @NotEmpty(message = "Username can not be empty.")
    @NotNull(message = "Username can not be null.")
    @Size(min = 3, message = "Username must contain at least 3 characters.")
    private String username;

    @NotEmpty(message = "Password can not be empty.")
    @NotNull(message = "Password can not be null.")
    @Size(min = 5, message = "Password must contain at least 5 characters.")
    private String password;

}
