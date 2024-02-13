package com.stackroute.UserAuthService.controller;


import com.stackroute.UserAuthService.exception.UserAlreadyExistsException;
import com.stackroute.UserAuthService.exception.UserNotFoundException;
import com.stackroute.UserAuthService.model.User;
import com.stackroute.UserAuthService.security.SecurityTokenGenerator;
import com.stackroute.UserAuthService.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins="*")
@RestController
public class UserAuthController {

    private UserAuthService userAuthService;
    private ResponseEntity responseEntity;
    private SecurityTokenGenerator serviceTokenGenerator;

    @Autowired
    public UserAuthController(UserAuthService userAuthService, SecurityTokenGenerator serviceTokenGenerator) {

        this.userAuthService = userAuthService;
        this.serviceTokenGenerator = serviceTokenGenerator;
    }

    @PostConstruct
    public void initRolesAndUsers(){
        userAuthService.initRolesAndUser();
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {

        try {

            return new ResponseEntity(userAuthService.addNewUser(user), HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {

            throw new UserAlreadyExistsException();
        } catch (Exception e) {

            return new ResponseEntity(" internal error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {

        Map<String, String> map = new HashMap<>();

        try {
            User userObj = userAuthService.loginUser(user.getUserEmail(), user.getPassword());
            if (userObj.getUserEmail().equals(user.getUserEmail())) {
                map = serviceTokenGenerator.generateToken(userObj);
            }
            return new ResponseEntity(map, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {

            return new ResponseEntity("error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update/{userEmail}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable("userEmail") String userEmail) throws UserNotFoundException {
        return new ResponseEntity<>(userAuthService.updateUserDetails(user,userEmail),HttpStatus.OK);
    }


}
