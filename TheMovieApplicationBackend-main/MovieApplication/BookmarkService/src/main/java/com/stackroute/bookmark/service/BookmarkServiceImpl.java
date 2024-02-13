package com.stackroute.bookmark.service;

//import com.stackroute.bookmark.config.Consumer;
import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
import com.stackroute.bookmark.exception.MovieAlreadyExists;
import com.stackroute.bookmark.exception.UserNotFoundException;
import com.stackroute.bookmark.model.Bookmark;
import com.stackroute.bookmark.model.Movie;
import com.stackroute.bookmark.model.User;
import com.stackroute.bookmark.repository.MyBookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService{

    private MyBookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(MyBookmarkRepository bookmarkRepository){
        this.bookmarkRepository=bookmarkRepository;
    }

    @Override
    public User addMovieToBookmark(Movie movie, String userEmail) throws UserNotFoundException, MovieAlreadyExists {
        System.out.println("66 in S");
        if(bookmarkRepository.findById(userEmail).isEmpty())
        {
            System.out.println("69 in S");
//            throw new UserNotFoundException();
            User user = new User();
            user.setUserEmail(userEmail);
            bookmarkRepository.save(user);
        }
        System.out.println("72 in S");
        User user = bookmarkRepository.findById(userEmail).get();
        System.out.println("74 in S");

        if(user.getBookmark()==null){
            Bookmark bookmark = new Bookmark();
            System.out.println("78 in S");
            bookmark.setBookmarkId((int)Math.random()*1000);
            System.out.println("80 in S");
            bookmark.setBookmarkName("Bookmark1");
            System.out.println("82 in S");

            List<Movie> movieList = new ArrayList<>();
            System.out.println("85 in S");
            movieList.add(movie);
            System.out.println("87 in S");
            bookmark.setMovie(movieList);
            System.out.println("89 in S");
            user.setBookmark(bookmark);
            bookmarkRepository.save(user);
            System.out.println("95 in S");
            return user;
        }

        else{
            Bookmark bookmark = user.getBookmark();
            System.out.println("77 in S");
            List<Movie> allMovies = bookmark.getMovie();
            for(Movie m : allMovies){
                if(m.getId()==movie.getId()){
                    throw new MovieAlreadyExists();
                }
            }
            allMovies.add(movie);
            bookmark.setMovie(allMovies);
            user.setBookmark(bookmark);
            bookmarkRepository.save(user);
            System.out.println("95 in S");
            return user;

        }

    }

    @Override
    public User deleteBookmark(int id, String userEmail) throws UserNotFoundException, BookmarkNameNotFoundException {
        User user1 = new User();
        if(bookmarkRepository.findById(userEmail).isEmpty())
        {
            User user = new User();
            user.setUserEmail(userEmail);
            bookmarkRepository.save(user);
        }
        System.out.println("91 in S");
        User user=bookmarkRepository.findById(userEmail).get();
        System.out.println("93 in S");
        Bookmark bookmark = user.getBookmark();
        System.out.println("95 in S");
        List<Movie> movieList = user.getBookmark().getMovie();
        System.out.println("97 in S" + movieList);
        for(Movie m : movieList){
            System.out.println("99 in S" +m);
            if(m.getId()==id){
                System.out.println("101 in S" +m);
                System.out.println("102 in S");
                movieList.remove(m);
                bookmark.setMovie(movieList);
                System.out.println("104 in S" +movieList);
                System.out.println("106 in S" +bookmark);
                user.setBookmark(bookmark);
                System.out.println("108 in S"+ user);
                user1 = bookmarkRepository.save(user);
            }
        }
        System.out.println("112 in S" +user1);
        return user1;

    }

    @Override
    public List<Movie> getAllBookmark(String bookmarkName, String userEmail) throws BookmarkNameNotFoundException {
        if(bookmarkRepository.findById(userEmail).isEmpty())
        {
            throw new BookmarkNameNotFoundException();
        }
        User user = bookmarkRepository.findById(userEmail).get();
        System.out.println("129 "+user);
        Bookmark bookmark2 = user.getBookmark();
//        Bookmark p1 = new Bookmark();
//
//            if(bookmark2.getBookmarkName().equals("Bookmark1")){
//                p1 = bookmark2;
//                System.out.println("136 "+p1);
//
//
//        }
        System.out.println("139 "+bookmark2.getMovie());
        return bookmark2.getMovie();
//        System.out.println(playlist2);
//        return playlistRepository.getPlaylistByPlaylistName("playlist1");

    }


}


