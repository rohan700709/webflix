package com.stackroute.bookmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CREATED, reason = "Movie already exists")
public class MovieAlreadyExists extends Exception{
}
