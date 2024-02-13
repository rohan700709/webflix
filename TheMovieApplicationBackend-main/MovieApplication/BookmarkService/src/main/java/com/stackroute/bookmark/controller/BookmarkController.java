package com.stackroute.bookmark.controller;

import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
import com.stackroute.bookmark.exception.MovieAlreadyExists;
import com.stackroute.bookmark.exception.UserNotFoundException;
import com.stackroute.bookmark.model.Bookmark;
import com.stackroute.bookmark.model.Movie;
import com.stackroute.bookmark.service.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
public class BookmarkController {

    private BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    private ResponseEntity responseEntity;


    @PostMapping("api/v1/bookmarkservice/{userEmail}")
    public ResponseEntity<?> createPlaylist(@RequestBody Movie movie, @PathVariable("userEmail") String userEmail) throws UserNotFoundException, MovieAlreadyExists {
        System.out.println("48");
        System.out.println(movie);
        ResponseEntity<Object> responseEntity;
        try {
            System.out.println("51");
            responseEntity=new ResponseEntity<>(bookmarkService.addMovieToBookmark(movie,userEmail), HttpStatus.CREATED);
            System.out.println("53");
        }

        catch (UserNotFoundException ue)
        {
            System.out.println("58");
            throw new UserNotFoundException();
        }
        catch (MovieAlreadyExists me)
        {
            System.out.println("63");
            throw new MovieAlreadyExists();
        }
        catch (Exception e)
        {
            System.out.println("63");
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        System.out.println("67");
        return responseEntity;
    }

    @DeleteMapping("api/v1/bookmarkservice/bookmark/{userEmail}/{id}")
    public ResponseEntity<?> deleteBookmark(@PathVariable int id, @PathVariable String userEmail) throws UserNotFoundException {
        System.out.println("59 in C");
        try{
            System.out.println("61 in C");
            responseEntity=new ResponseEntity<>(bookmarkService.deleteBookmark(id,userEmail),HttpStatus.OK);
        }
        catch (UserNotFoundException ue)
        {
            System.out.println("66 in C");
            throw new UserNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("api/v1/bookmarkservice/bookmark/{userEmail}/{bookmarkName}")
    public ResponseEntity<?> getBookmarkByBookmarkName(@PathVariable String bookmarkName, @PathVariable String userEmail)
    {
        try{
            responseEntity=new ResponseEntity(bookmarkService.getAllBookmark(bookmarkName, userEmail),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            responseEntity=new ResponseEntity<>("Error try After Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
