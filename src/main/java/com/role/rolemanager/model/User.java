package com.role.rolemanager.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.role.rolemanager.model.idclass.UserID;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "users")
@IdClass(UserID.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Id
    @Column(name = "username", unique = true, nullable = false, updatable = false)
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "role")
    private String role;
    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Credential credential;

    public User(){}

    public User(Long id, String username, String name, String surname, String role){
        this.id= id;
        this.username= username;
        this.name= name;
        this.surname= surname;
        this.role= role;
    }

    public User(String username, String name, String surname, String role){
        this.username= username;
        this.name= name;
        this.surname= surname;
        this.role= role;
    }

    //getters
    public Long getId(){
        return this.id;
    }
    public String getUsername() {
        return username;
    }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getRole() {
        return role;
    }
    public Credential getCredential() {
        return credential;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
