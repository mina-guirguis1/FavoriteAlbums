package com.perficient.demo.repository;

import org.springframework.data.jpa.repository.*;

import com.perficient.demo.model.Album;


public interface AlbumRepository extends JpaRepository<Album, Long>{
	
}
