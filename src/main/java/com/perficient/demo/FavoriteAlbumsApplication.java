package com.perficient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

import com.perficient.demo.controller.AlbumController;

@SpringBootApplication
public class FavoriteAlbumsApplication {
	
	@GetMapping("/")
	public static void main(String[] args) {
		SpringApplication.run(FavoriteAlbumsApplication.class, args);
		System.out.print("test");
	}

}
