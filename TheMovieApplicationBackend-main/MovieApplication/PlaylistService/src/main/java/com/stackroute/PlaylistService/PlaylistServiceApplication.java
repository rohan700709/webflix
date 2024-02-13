package com.stackroute.PlaylistService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PlaylistServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistServiceApplication.class, args);
	}

}
