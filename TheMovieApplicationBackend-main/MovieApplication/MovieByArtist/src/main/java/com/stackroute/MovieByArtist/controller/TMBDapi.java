package com.stackroute.MovieByArtist.controller;

import com.stackroute.MovieByArtist.config.Producer;
import com.stackroute.MovieByArtist.model.MovieList;
import com.stackroute.MovieByArtist.model.Results;
import com.stackroute.MovieByArtist.rabbitMQ.domain.MovieListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movieService")
public class TMBDapi {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private Producer producer;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/search/{artist}")
    public MovieList searchMovieByArtist(@PathVariable("artist") String artist)
    {
        Results results = restTemplate.getForObject("https://api.themoviedb.org/3/search/person"+"?api_key=" +apiKey+"&query="+artist,Results.class);
        MovieList movieList = new MovieList(results.getTotal_results(), results.getTotal_pages(),results.getResults());
        System.out.println("Data from the API :: "+movieList);
        MovieListDTO movieListDTO = new MovieListDTO(results.getTotal_results(), results.getTotal_pages(),results.getResults());
        producer.sendMovieDetails(movieListDTO);
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
        return movieList;
    }
}
