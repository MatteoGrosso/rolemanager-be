package com.role.rolemanager.controller;

import com.role.rolemanager.dto.input.CredentialInputDTO;
import com.role.rolemanager.dto.input.UserInputDTO;
import com.role.rolemanager.dto.output.UserOutputDTO;
import com.role.rolemanager.model.User;
import com.role.rolemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserOutputDTO>> getUsers(){
        List<UserOutputDTO> users= userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserInputDTO user){
        User newUser= userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UserInputDTO user){
        User updatedUser= userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody String username){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> checkLogin(@RequestBody CredentialInputDTO user){
        Boolean grantedAccess= userService.checkLogin(user);
        return new ResponseEntity<>(grantedAccess, HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetUserPassword(@RequestBody String username){
        userService.resetUserPassword(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<UserOutputDTO> findUserByUsername(@RequestBody String username){
        UserOutputDTO user= userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
