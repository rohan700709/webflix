package com.stackroute.PlaylistService.controller;

import com.stackroute.PlaylistService.domain.Movie;
import com.stackroute.PlaylistService.domain.Playlist;
import com.stackroute.PlaylistService.exception.PlayListNameNotFoundException;
import com.stackroute.PlaylistService.exception.PlaylistNameAlreadyExists;
import com.stackroute.PlaylistService.exception.UserNotFoundException;
import com.stackroute.PlaylistService.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
public class PlaylistController {

    private PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService){
        this.playlistService=playlistService;
    }

    private ResponseEntity responseEntity;

//    @PostMapping("/api/v1/playlistservice/{userEmail}")
//    public ResponseEntity<?> createPlaylist(@RequestBody Playlist playlist, @PathVariable("userEmail") String userEmail) throws UserNotFoundException {
//
//        ResponseEntity<Object> responseEntity;
//        try {
//
//            responseEntity=new ResponseEntity<>(playlistService.createPlaylist(playlist,userEmail), HttpStatus.CREATED);
//        }
//        catch (UserNotFoundException ue)
//        {
//            throw new UserNotFoundException();
//        }
//        catch (Exception e)
//        {
//            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return responseEntity;
//    }

    @PostMapping("api/v1/playlistservice/{userEmail}/{playlistName}")
    public ResponseEntity<?> createPlaylist(@RequestBody Movie movie, @PathVariable("userEmail") String userEmail
    , @PathVariable("playlistName") String playlistName) throws UserNotFoundException {
        System.out.println("48");
        System.out.println(movie);
        ResponseEntity<Object> responseEntity;
        try {
            System.out.println("51");
            responseEntity=new ResponseEntity<>(playlistService.addMovieToPlaylist(movie,userEmail,playlistName), HttpStatus.CREATED);
            System.out.println("53");
        }

        catch (UserNotFoundException ue)
        {
            System.out.println("58");
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            System.out.println("63");
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        System.out.println("67");
        return responseEntity;
    }

    @DeleteMapping("/api/v1/playlistservice/playlist/{userEmail}/{playlistName}")
    public ResponseEntity<?> deleteTrack( @PathVariable String playlistName, @PathVariable String userEmail) throws PlayListNameNotFoundException, UserNotFoundException
    {
        try {

            responseEntity=new ResponseEntity<>(playlistService.deletePlayList(playlistName, userEmail), HttpStatus.OK);
        }
        catch(PlayListNameNotFoundException pe)
        {
            throw new PlayListNameNotFoundException();
        }
        catch(UserNotFoundException ue)
        {
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @DeleteMapping("/api/v1/playlistservice/movie/{userEmail}/{playlistName}/{id}")
    public ResponseEntity<?> deleteTrack( @PathVariable String playlistName, @PathVariable String userEmail,
                                          @PathVariable int id) throws UserNotFoundException
    {
        try {

            responseEntity=new ResponseEntity<>(playlistService.deleteMovieFromPlayList(id, playlistName, userEmail), HttpStatus.OK);
        }
        catch(UserNotFoundException ue)
        {
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }

    @GetMapping("api/v1/playlistservice/playlist/{userEmail}/{playlistName}")
    public ResponseEntity<?> getPlaylistByPlaylistName(@PathVariable String playlistName, @PathVariable String userEmail)
    {
        try{
            responseEntity=new ResponseEntity(playlistService.getAllPlaylist(playlistName, userEmail),HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("api/v1/playlistservice/playlist/{userEmail}")
    public ResponseEntity<?> getPlaylistName(@PathVariable String userEmail) throws UserNotFoundException
    {
        try{
            responseEntity=new ResponseEntity(playlistService.getPlaylistName(userEmail),HttpStatus.OK);
        }
        catch(UserNotFoundException ue)
        {
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


    @PostMapping("api/v1/playlistservice/createNewPlaylist/{userEmail}")
    public ResponseEntity<?> createNewPlaylist(@PathVariable("userEmail") String userEmail,
                                               @RequestBody String playlistName) throws PlaylistNameAlreadyExists {
        ResponseEntity<Object> responseEntity;
        try {
            responseEntity=new ResponseEntity<>(playlistService.createNewPlayList(userEmail, playlistName), HttpStatus.CREATED);
            System.out.println("53");
        }

        catch (PlaylistNameAlreadyExists pe)
        {
            System.out.println("58");
            throw new PlaylistNameAlreadyExists();
        }
        catch (Exception e)
        {
            System.out.println("63");
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        System.out.println("67");
        return responseEntity;
    }


}
