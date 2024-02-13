package com.stackroute.bookmark.service;

import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
import com.stackroute.bookmark.exception.MovieAlreadyExists;
import com.stackroute.bookmark.exception.UserNotFoundException;
import com.stackroute.bookmark.model.Bookmark;
import com.stackroute.bookmark.model.Movie;
import com.stackroute.bookmark.model.User;

import java.util.List;

public interface BookmarkService {

    //User createBookmark(Bookmark bookmark,String userEmail) throws UserNotFoundException, BookmarkNameNotFoundException;
    User addMovieToBookmark(Movie movie, String userEmail) throws UserNotFoundException, MovieAlreadyExists;
    User deleteBookmark(int id, String userEmail) throws UserNotFoundException, BookmarkNameNotFoundException;
    List<Movie> getAllBookmark(String bookmarkName, String userEmail) throws BookmarkNameNotFoundException;
}
