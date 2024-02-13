//package com.stackroute.bookmark.config;
//
//import com.stackroute.bookmark.exception.BookmarkNameNotFoundException;
//import com.stackroute.bookmark.exception.UserNotFoundException;
//import com.stackroute.bookmark.model.Movie;
//import com.stackroute.bookmark.rabbitmq.domain.MovieDTO;
//import com.stackroute.bookmark.service.BookmarkServiceImpl;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Consumer {
//
//    @Autowired
//    private BookmarkServiceImpl bookmarkService;
//
//    @RabbitListener(queues="bookmark_queue")
//    public Movie getMovieDTOFromRabbitMq(MovieDTO movieDTO) throws UserNotFoundException, BookmarkNameNotFoundException {
//
//        Movie movie=new Movie();
//        movie.setMovieId(movieDTO.getMovieId());
//        movie.setMovieTitle(movieDTO.getMovieTitle());
//        movie.setArtist(movieDTO.getArtist());
//        movie.setGenre(movieDTO.getGenre());
//        movie.setRating(movieDTO.getRating());
//        return movie;
//
//    }
//}
