package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.proxy.UserProxy;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProxy userProxy){

        this.userRepository=userRepository;
        this.userProxy=userProxy;
    }

    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getUserEmail()).isPresent()){
            throw new UserAlreadyExistException();
        }

        ResponseEntity r = userProxy.registerUser(user);
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(String userEmail) throws UserNotFoundException {
        boolean flag=false;
        if (userRepository.findById(userEmail).isEmpty()){
            throw new UserNotFoundException();
        }
        else {
            userRepository.deleteById(userEmail);
            flag=true;
        }
        return flag;
    }

    @Override
    public User updateUser(User user, String userEmail) throws UserNotFoundException {
        User getUser = userRepository.findById(userEmail).get();
        if(Optional.ofNullable(getUser).isEmpty()){
            throw new UserNotFoundException();
        }
        getUser.setUserName(user.getUserName());
        getUser.setPassword(user.getPassword());
        ResponseEntity r = userProxy.updateUser(getUser, userEmail);
        User  updateUser = userRepository.save(getUser);
        return updateUser;
    }

    @Override
    public User getUser(String userEmail) throws UserNotFoundException {
        if (userRepository.findById(userEmail).isEmpty()){
            throw new UserNotFoundException();
        }
        return userRepository.findById(userEmail).get();
    }
}



























