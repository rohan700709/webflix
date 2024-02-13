package com.stackroute.TrendingMovies.controller;

import com.stackroute.TrendingMovies.config.Producer;
import com.stackroute.TrendingMovies.model.MovieList;
import com.stackroute.TrendingMovies.model.Results;
import com.stackroute.TrendingMovies.rabbitMQ.model.MovieListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/movieService")
public class TBDMapi {
    @Value("${api.key}")
    private String apiKey;

    //to consume RESTful Web Services
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Producer producer;

    @RequestMapping("/popular")
    public MovieList getPopularMovies()
    {
        //getForObject is used to convert the HTTP response into an object type
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/popular" + "?api_key=" +  apiKey, Results.class);
        MovieList list = new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from teh API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
//        producer.sendMovieDetails(movieListDTO);
        return list;
    }

    @RequestMapping("/upcoming")
    public MovieList getUpcomingMovies()
    {
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/upcoming" + "?api_key=" +  apiKey, Results.class);
        MovieList list = new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from the API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
//        producer.sendMovieDetails(movieListDTO);
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
        return list;
    }

    @RequestMapping("/now_playing")
    public MovieList getNowPlayingMovies()
    {
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/latest" + "?api_key=" +  apiKey, Results.class);
        MovieList list= new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from the API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
//        producer.sendMovieDetails(movieListDTO);
        return list;
    }

    @RequestMapping("/trending")
    public MovieList getTrendingMovies()
    {
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/now_playing" + "?api_key=" +  apiKey, Results.class);
        MovieList list= new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from the API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
//        producer.sendMovieDetails(movieListDTO);
        return list;
    }

    @RequestMapping("/top_rated")
    public MovieList getTopRatedMovies()
    {
        Results results =  restTemplate.getForObject("https://api.themoviedb.org/3/movie/top_rated" + "?api_key=" +  apiKey, Results.class);
        MovieList list= new MovieList(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data from the API :: "+list);
        MovieListDTO movieListDTO = new MovieListDTO(results.getPage(),results.getTotal_results(),results.getTotal_pages(),results.getResults());
        System.out.println("Data in RabbitMQ :: "+movieListDTO);
//        producer.sendMovieDetails(movieListDTO);
        return list;
    }
}
