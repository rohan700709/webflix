package com.stackroute.MovieByTitle.controller;


import com.stackroute.MovieByTitle.RabbitMQ.model.MovieListDTO;
//import com.stackroute.MovieByTitle.config.Producer;
import com.stackroute.MovieByTitle.model.MovieList;
import com.stackroute.MovieByTitle.model.Results;
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
public class TBDMapi {
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private Producer producer;

    @RequestMapping("/search/{title}")
    public MovieList searchMovieByTitle(@PathVariable("title") String title)
    {
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/search/movie"+"?api_key=" +apiKey+"&query="+title,Results.class);
        MovieList list = new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from teh API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
//        producer.sendMovieDetails(movieListDTO);
        return list;
    }
}
