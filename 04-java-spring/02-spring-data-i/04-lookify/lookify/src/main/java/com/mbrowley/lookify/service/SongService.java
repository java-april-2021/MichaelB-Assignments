package com.mbrowley.lookify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbrowley.lookify.model.Song;
import com.mbrowley.lookify.repository.SongRepository;
@Service
public class SongService {
	
	//dependacy injection
	private SongRepository sRepository;
	
	public SongService(SongRepository sRepo) {
		this.sRepository = sRepo;
	}
	
	
	
	// get all songs
	public List<Song> getAllSongs(){
		return this.sRepository.findAll();
	}
	
	//get one Song
	public Song getOneSong(Long id) {
		return this.sRepository.findById(id).orElse(null);
	}
	
	//find song by artist
	public List<Song> searchArtist(String artist) {
		return this.sRepository.findByArtistContaining(artist);
	}
	
	//delete song by artist
	public void delSearch(Long id) {
		 this.sRepository.deleteById(id);
	}
	
	//create one song
	public Song createSong(Song newSong) {
		return this.sRepository.save(newSong);
	}

	//delete on song
	public void deleteSong(Long id) {
		this.sRepository.deleteById(id);
	}
	
	// update a book
	public Song updateSong(Song updatedSong) {
		return this.sRepository.save(updatedSong);
	}
	
	// top 10 songs
	public List<Song> getTopTenSongs() {
		return this.sRepository.findFirst10ByOrderByRatingDesc();
	}
	
}


