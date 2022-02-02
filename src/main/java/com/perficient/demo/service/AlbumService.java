package com.perficient.demo.service;

import java.util.List;

import com.perficient.demo.model.Album;

public interface AlbumService {
	Album saveAlbum(Album album);
	List<Album> getAllAlbums();
	Album getAlbumById(long id);
	Album updateAlbum(Album album, long id);
	void deleteAlbum(long id);
}
