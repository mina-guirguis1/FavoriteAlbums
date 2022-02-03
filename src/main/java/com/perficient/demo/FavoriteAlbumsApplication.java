package com.perficient.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perficient.demo.controller.AlbumController;
import com.perficient.demo.service.AlbumService;

@SpringBootApplication
public class FavoriteAlbumsApplication {
	private AlbumService albumService;
	@GetMapping("/")
	public static void main(String[] args) {
		SpringApplication.run(FavoriteAlbumsApplication.class, args);
		System.out.print("test");
	}
	@GetMapping("/")
	public String viewHomePag(Model model) {
		model.addAttribute("listAlbums", albumService.getAllAlbums());
		return "index";
	}
	
}
