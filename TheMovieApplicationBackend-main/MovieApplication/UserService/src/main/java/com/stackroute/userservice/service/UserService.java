package com.stackroute.userservice.service;

import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;

public interface UserService {

    User addUser(User user) throws UserAlreadyExistException;

    boolean deleteUser(String userEmail) throws UserNotFoundException;

    User updateUser(User user, String userEmail) throws UserNotFoundException;

    User getUser(String userEmail) throws UserNotFoundException;




















}
