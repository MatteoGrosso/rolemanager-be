package com.role.rolemanager.dto.input;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialInputDTO {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

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
