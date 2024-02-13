package com.stackroute.userservice.controller;


import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController

@RequestMapping("api/v1/")
public class UserController {
    private UserService userService;

    private ResponseEntity responseEntity;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("user")
    public ResponseEntity<?> addUser(@RequestBody User user)throws UserAlreadyExistException {
        try {
            userService.addUser(user);
            responseEntity = new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            throw new UserAlreadyExistException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error Try After Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
        }

    @DeleteMapping("user/{userEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable String userEmail)throws UserNotFoundException{
        try{
            userService.deleteUser(userEmail);
            responseEntity=new ResponseEntity<>("Successfully Deleted !!",HttpStatus.OK);
        }
        catch (UserNotFoundException e){
            throw new UserNotFoundException();}
        catch (Exception e){
            responseEntity=new ResponseEntity<>("Error Try After Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("user/{userEmail}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable("userEmail") String userEmail) throws UserNotFoundException {
        return new ResponseEntity<>(userService.updateUser(user,userEmail),HttpStatus.OK);
    }

    @GetMapping("user/{userEmail}")
    public ResponseEntity<?> getUser(@PathVariable("userEmail") String userEmail) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getUser(userEmail),HttpStatus.OK);
    }

}































