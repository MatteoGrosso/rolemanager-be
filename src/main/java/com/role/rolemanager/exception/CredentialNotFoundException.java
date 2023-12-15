package com.role.rolemanager.exception;

public class CredentialNotFoundException extends RuntimeException{
    public CredentialNotFoundException(String message){
        super(message);
    }
}
