package com.role.rolemanager.repository;

import com.role.rolemanager.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findCredentialByUsername(String username);
}
