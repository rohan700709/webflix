package com.stackroute.UserAuthService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "user already exist exception")
public class UserAlreadyExistsException extends Exception {
}
