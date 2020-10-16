package com.pavolpodstreleny.CloudStorage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Credential {

    private Integer id;
    private String url;
    private String userName;
    private String key;
    private String passwordEncrypted;
    private String passwordDecrypted;
    private Integer userId;

    public Credential(Integer id, String url, String userName, String key, String passwordEncrypted, Integer userId) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.passwordEncrypted = passwordEncrypted;
        this.userId = userId;
    }

}