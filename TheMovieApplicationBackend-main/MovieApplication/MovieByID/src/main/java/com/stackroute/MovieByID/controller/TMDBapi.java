package com.stackroute.MovieByID.controller;

import com.stackroute.MovieByID.config.Producer;
import com.stackroute.MovieByID.model.MovieDetails;
import com.stackroute.MovieByID.model.MovieFields;
import com.stackroute.MovieByID.rabbitMQ.domain.MovieDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/movieService")
public class TMDBapi {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private Producer producer;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/{movieId}")
    public MovieDetails getMovieInfo(@PathVariable("movieId") int movieId)
    {
        MovieFields fields = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey, MovieFields.class);
        MovieDetails movie = new MovieDetails(movieId, fields.getTitle(),fields.getOverview(),fields.getPoster_path(),fields.getBackdrop_path(),fields.getGenres(),fields.getRelease_date(),fields.getVote_average());
        System.out.println("Data from the API :: "+movie);
        MovieDetailsDTO movieDTO = new MovieDetailsDTO(movieId, fields.getTitle(),fields.getOverview(),fields.getPoster_path(),fields.getBackdrop_path(),fields.getGenres(),fields.getRelease_date(),fields.getVote_average());
        producer.sendMovieDetails(movieDTO);
        System.out.println("Data in RabbitMQ :: "+movieDTO);
        return movie;
    }
}
