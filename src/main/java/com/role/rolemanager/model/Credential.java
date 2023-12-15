package com.role.rolemanager.model;


import com.role.rolemanager.model.idclass.CredentialID;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "credential")
@IdClass(CredentialID.class)
public class Credential implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "username")
    private String username;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "id"),
            @JoinColumn(name = "username", referencedColumnName = "username")
    })
    @MapsId("userId")
    private User user;

    @Column(name = "password")
    private String password;

    public Credential() {}

    public Credential(User user, String password) {
        this.user = user;
        this.password = password;
        // Setting pk fk values
        this.userId = user.getId();
        this.username = user.getUsername();
    }

    //getters

    public String getUsername() {
        return username;
    }
    public User getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUser(User user) {
        this.user = user;
        // Set the composite key values
        this.userId = user.getId();
        this.username = user.getUsername();
    }
}

