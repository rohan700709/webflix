//package com.stackroute.PlaylistService.config;
//
//import com.stackroute.PlaylistService.domain.Movie;
//import com.stackroute.PlaylistService.rabbitmq.domain.MovieDTO;
//import com.stackroute.PlaylistService.service.PlayListServiceImpl;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class Consumer {
//    @Autowired
//    private PlayListServiceImpl playlistService;
//
//    @RabbitListener(queues="playlist_queue")
//    public List<Movie> getMovieDTOFromRabbitMq(MovieDTO movieDTO) {
//
//        List<Movie> movieList = new ArrayList<>();
//        Movie movie = new Movie();
//        movie.setMovieId(movieDTO.getMovieId());
//        movie.setMovieTitle(movieDTO.getMovieTitle());
//        movie.setArtistName(movieDTO.getArtistName());
//        movie.setGenreName(movieDTO.getGenreName());
//        movie.setRating(movieDTO.getRating());
//        movieList.add(movie);
//        return movieList;
//
//    }
//}
