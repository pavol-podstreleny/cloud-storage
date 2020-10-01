package com.pavolpodstreleny.CloudStorage.entity;

public class Credential {
    private Integer id;
    private String url;
    private String userName;
    private String key;
    private String passwordEncrypted;
    private String passwordDecrypted;
    private Integer userId;

    public Credential(Integer id, String url, String userName, String key, String password, Integer userId) {
        this.id = id;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.passwordEncrypted = password;
        this.userId = userId;
    }

    public Credential(String url, String userName, String key, String password, Integer userId) {
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.passwordEncrypted = password;
        this.userId = userId;
    }

    public Credential(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.passwordDecrypted = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPasswordDecrypted() {
        return passwordDecrypted;
    }

    public void setPasswordDecrypted(String passwordDecrypted) {
        this.passwordDecrypted = passwordDecrypted;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }
}