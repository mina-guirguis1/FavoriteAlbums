package com.perficient.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.demo.model.Album;
import com.perficient.demo.service.AlbumService;


//@RestController
//@RequestMapping("/api/albums")
@Controller
public class AlbumController {

	private AlbumService albumService;
	
	//display list of albums 
	@GetMapping("/")
	public String viewHomePag(Model model) {
		model.addAttribute("listAlbums", albumService.getAllAlbums());
		return "index";
	}

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	
	//add album
	@PostMapping()
	public ResponseEntity<Album> saveAlbum(@RequestBody Album album) {
		return new ResponseEntity<Album>(albumService.saveAlbum(album), HttpStatus.CREATED);
	}
	
	@GetMapping("/showNewAlbumForm")
	public String showNewAlbumForm(Model model) {
		Album album = new Album();
		model.addAttribute("album", album);
		return "newAlbum";
		
	}
	
	@PostMapping("/saveAlbum")
	public String saveAlbumString(@ModelAttribute("album") Album album) {
		//save album to DB
		albumService.saveAlbum(album);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model ) {
		
		//get album from service 
		Album album = albumService.getAlbumById(id);
		
		model.addAttribute("album", album);
		
		return "updateAlbum";
	}

	// get all albums
	@GetMapping
	public List<Album> getAllAlbums() {
		return albumService.getAllAlbums();
	}
	
	//get album by ID
	@GetMapping("/api/albums/{id}")
	public ResponseEntity<Album> getAlbumById(@PathVariable("id") long id) {
		return new ResponseEntity<Album>(albumService.getAlbumById(id), HttpStatus.OK);
	}
	
	//update album 
	@PutMapping("{id}")
	public ResponseEntity<Album> updateAlbum(@PathVariable("id") long id, @RequestBody Album album) {
		return new  ResponseEntity<Album>(albumService.updateAlbum(album, id), HttpStatus.OK);
	}
	
	//delete album
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAlbum(@PathVariable("id") long id) {
		
		albumService.deleteAlbum(id);
		
		return new ResponseEntity<String>("Album deleted successfully", HttpStatus.OK);
	}
}
