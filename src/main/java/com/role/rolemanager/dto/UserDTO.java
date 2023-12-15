package com.role.rolemanager.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
    @JsonProperty("id")
    private Long id;
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

    public UserDTO(){}

    public UserDTO(Long id, String name, String surname, String role, String username, String password){
        this.id= id;
        this.name= name;
        this.surname= surname;
        this.role= role;
        this.username= username;
        this.password= password;
    }

    //getters
    public Long getId() {
        return id;
    }
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
    public void setId(Long id) {
        this.id = id;
    }
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
