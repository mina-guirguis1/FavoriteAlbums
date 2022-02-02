package com.perficient.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.demo.model.Album;
import com.perficient.demo.service.AlbumService;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {

	private AlbumService albumService;

	public AlbumController(AlbumService albumService) {
		super();
		this.albumService = albumService;
	}
	
	//add album
	@PostMapping()
	public ResponseEntity<Album> saveAlbum(@RequestBody Album album) {
		return new ResponseEntity<Album>(albumService.saveAlbum(album), HttpStatus.CREATED);
	}
	

	// get all albums
	@GetMapping
	public List<Album> getAllAlbums() {
		return albumService.getAllAlbums();
	}
	
	//get album by ID
	@GetMapping("{id}")
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
