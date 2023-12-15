package com.role.rolemanager.dto;



public class CredentialDTO {
    private String username;
    private String password;

    public CredentialDTO(){}

    public CredentialDTO(String username, String password){}

    //getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
