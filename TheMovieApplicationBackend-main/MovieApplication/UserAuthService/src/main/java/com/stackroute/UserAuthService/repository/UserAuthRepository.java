package com.stackroute.UserAuthService.repository;

import com.stackroute.UserAuthService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<User, String> {


    User findByUserEmailAndPassword(String userEmail, String password);


}
