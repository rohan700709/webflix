package com.stackroute.MovieByID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieByIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieByIdApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
