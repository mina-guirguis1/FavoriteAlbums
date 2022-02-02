package com.perficient.demo.model;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "album_name", nullable = false)
	private String album_name;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "num_of_songs")
	private int numOfSongs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getNumOfSongs() {
		return numOfSongs;
	}

	public void setNumOfSongs(int numOfSongs) {
		this.numOfSongs = numOfSongs;
	}
	

}
