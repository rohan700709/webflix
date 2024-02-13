package com.stackroute.UserAuthService.service;


import com.stackroute.UserAuthService.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthService.exception.UserNotFoundException;
import com.stackroute.UserAuthService.model.User;

public interface UserAuthService {

    public User loginUser(String email, String password) throws UserNotFoundException;

    public User addNewUser(User user) throws UserAlreadyExistsException;

    public void initRolesAndUser();

    public User updateUserDetails(User user, String userEmail) throws UserNotFoundException;



}
