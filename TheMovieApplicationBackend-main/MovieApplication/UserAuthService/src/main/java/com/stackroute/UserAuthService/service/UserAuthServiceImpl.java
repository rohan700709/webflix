package com.stackroute.UserAuthService.service;


import com.stackroute.UserAuthService.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthService.exception.UserNotFoundException;
import com.stackroute.UserAuthService.model.User;
import com.stackroute.UserAuthService.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserAuthServiceImpl implements UserAuthService {

    private UserAuthRepository userRepository;

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User loginUser(String userEmail, String password) throws UserNotFoundException {

        System.out.println("28");
        User user = userRepository.findByUserEmailAndPassword(userEmail, password);
        System.out.println("30" +user);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    @Override
    public User addNewUser(User user) throws UserAlreadyExistsException {

        if (userRepository.findById(user.getUserEmail()).isPresent()) {

            throw new UserAlreadyExistsException();
        }

        user.setRole("User");
        userRepository.save(user);

        return userRepository.findById(user.getUserEmail()).get();
    }

    @Override
    public void initRolesAndUser(){

        User adminUser = new User();
        adminUser.setUserEmail("admin@gmail.com");
        adminUser.setPassword("admin123");
        adminUser.setRole("Admin");
        userRepository.save(adminUser);
    }

    @Override
    public User updateUserDetails(User user, String userEmail) throws UserNotFoundException {
        User getUser = userRepository.findById(userEmail).get();
        if(Optional.ofNullable(getUser).isEmpty()){
            throw new UserNotFoundException();
        }
        getUser.setPassword(user.getPassword());
        User  updateUser = userRepository.save(getUser);
        return updateUser;
    }


}
