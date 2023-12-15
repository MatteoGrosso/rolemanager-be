package com.role.rolemanager.service;

import com.role.rolemanager.dto.input.CredentialInputDTO;
import com.role.rolemanager.dto.input.UserInputDTO;
import com.role.rolemanager.dto.output.UserOutputDTO;
import com.role.rolemanager.exception.CredentialNotFoundException;
import com.role.rolemanager.exception.UserNotFoundException;
import com.role.rolemanager.model.Credential;
import com.role.rolemanager.model.User;
import com.role.rolemanager.repository.CredentialRepository;
import com.role.rolemanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    public List<UserOutputDTO> findAll(){
        return userRepository.findAllUserOutputDTO().orElseThrow(() -> new UserNotFoundException("Users not found"));
    }
    public User addUser(UserInputDTO dto){
        User user= mapToUser(dto);
        User newUser= userRepository.save(user);
        newUser.setCredential(new Credential(newUser,dto.getPassword()));
        return userRepository.save(newUser);

    }
    public User updateUser(UserInputDTO dto){
        User user= userRepository.findUserByUsername(dto.getUsername()).orElseThrow(() -> new UserNotFoundException("User with username " + dto.getUsername() + " was not found"));

        user.setCredential(new Credential(user,dto.getPassword()));
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public void deleteUser(String username){
        User user= userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username " + username + " was not found"));
        Credential credential= credentialRepository.findCredentialByUsername(username).orElseThrow(() -> new UserNotFoundException("Credential associated to User with username " + username + " was not found"));
        user.setCredential(credential);
        userRepository.delete(user);
    }

    public Boolean checkLogin(CredentialInputDTO user){
        return user.getPassword().equals(credentialRepository.findCredentialByUsername(user.getUsername()).orElseThrow(() -> new CredentialNotFoundException("Credentials with username  "+user.getUsername()+" was not found")).getPassword()) ? true : false;
    }

    public void resetUserPassword(String username) {
        User user= userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username " + username + " was not found"));
        user.setCredential(new Credential(user,"0000"));
        userRepository.save(user);
    }

    public UserOutputDTO findUserByUsername(String username){
        return userRepository.findUserOutputDTOByUsername(username).orElseThrow(() -> new UserNotFoundException("User with username " + username + " was not found"));
    }



    //utility
    public User mapToUser(UserInputDTO dto){
        return new User(dto.getUsername(), dto.getName(), dto.getSurname(), dto.getRole());
    }
}
