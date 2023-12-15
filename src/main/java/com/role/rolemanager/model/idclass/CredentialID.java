package com.role.rolemanager.model.idclass;

import java.io.Serializable;
import java.util.Objects;

public class CredentialID implements Serializable {
    private Long userId;
    private String username;

    public CredentialID() {}

    public CredentialID(Long userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    //getters
    public Long getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    //setters
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CredentialID that = (CredentialID) o;
        return Objects.equals(userId, that.userId) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username);
    }
}
