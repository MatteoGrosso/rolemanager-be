package com.role.rolemanager.dto.input;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInputDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("role")
    private String role;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;

    //getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getRole() {
        return role;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
