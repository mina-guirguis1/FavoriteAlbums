package com.perficient.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.perficient.demo.exception.ResourceNotFoundException;
import com.perficient.demo.model.Album;
import com.perficient.demo.repository.AlbumRepository;
import com.perficient.demo.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService{

	private AlbumRepository albumRepository;
	
	
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		super();
		this.albumRepository = albumRepository;
	}


	@Override
	public Album saveAlbum(Album album) {
		return albumRepository.save(album);
	}


	@Override
	public List<Album> getAllAlbums() {
		return albumRepository.findAll();
	}


	@Override
	public Album getAlbumById(long id) {
//		Optional<Album> album = albumRepository.findById(id);
//		if(album.isPresent()) {
//			return album.get();
//		} else {
//			throw new ResourceNotFoundException("Album", "Id", id);
//		}
		return albumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Album", "Id", id));
	}


	@Override
	public Album updateAlbum(Album album, long id) {
		Album existingAlbum = albumRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Album", "Id", id));
		
		existingAlbum.setAlbum_name(album.getAlbum_name());
		existingAlbum.setArtist(album.getAlbum_name());
		existingAlbum.setNumOfSongs(album.getNumOfSongs());
		
		//save changes
		albumRepository.save(existingAlbum);
		
		return existingAlbum;
	}


	@Override
	public void deleteAlbum(long id) {
		
		//check if album exists
		albumRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Album", "Id", id));
		
		albumRepository.deleteById(id);
	}
	
}
