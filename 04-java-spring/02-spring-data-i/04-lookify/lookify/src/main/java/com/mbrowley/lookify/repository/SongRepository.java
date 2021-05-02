package com.mbrowley.lookify.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.lookify.model.Song;
@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	
	//find all songs
	List<Song> findAll();
	
	//find song by Artist 
	List<Song> findByArtistContaining(String search);
	
	//delete by title
	void deleteById(Long id);
	
	//find top ten
	List<Song> findFirst10ByOrderByRatingDesc();
	
}
 