package com.role.rolemanager.repository;

import com.role.rolemanager.dto.output.UserOutputDTO;
import com.role.rolemanager.model.User;
import com.role.rolemanager.model.idclass.UserID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
public interface UserRepository extends JpaRepository<User, UserID> {

    @Query("SELECT NEW com.role.rolemanager.dto.output.UserOutputDTO(u.id, u.name, u.surname, u.role, u.username, c.password) FROM User u LEFT JOIN credential c")
    Optional<List<UserOutputDTO>> findAllUserOutputDTO();

    @Query("SELECT NEW com.role.rolemanager.model.User(u.id, u.username, u.name, u.surname, u.role) FROM User u where u.username= :username")
    Optional<User> findUserByUsername(@Param("username") String username);

    @Query("SELECT NEW com.role.rolemanager.dto.output.UserOutputDTO(u.id, u.name, u.surname, u.role, u.username, c.password) FROM User u LEFT JOIN credential c where u.username= :username")
    Optional<UserOutputDTO> findUserOutputDTOByUsername(@Param("username") String username);

}
