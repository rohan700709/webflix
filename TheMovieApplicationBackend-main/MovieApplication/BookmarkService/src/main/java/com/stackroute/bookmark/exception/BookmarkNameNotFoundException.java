package com.stackroute.bookmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bookmark Not Found!!")
public class BookmarkNameNotFoundException extends Exception{
}
