package com.stackroute.PlaylistService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CREATED,reason="Playlist name already created")
public class PlaylistNameAlreadyExists extends Exception {
}
