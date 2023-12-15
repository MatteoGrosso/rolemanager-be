package com.role.rolemanager.model.idclass;

import java.io.Serializable;
import java.util.Objects;

public class UserID implements Serializable {
    private Long id;
    private String username;

    public UserID() {}

    public UserID(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    //getters
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserID userKey = (UserID) o;
        return Objects.equals(id, userKey.id) && Objects.equals(username, userKey.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
