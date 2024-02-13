package com.stackroute.userservice.proxy;

import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-authentication-service", url="localhost:8086")
public interface UserProxy {

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user);

    @PutMapping("/update/{userEmail}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable("userEmail") String userEmail);
}
