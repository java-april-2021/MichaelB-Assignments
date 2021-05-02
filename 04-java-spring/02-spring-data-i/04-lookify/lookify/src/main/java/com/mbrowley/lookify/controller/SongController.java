package com.mbrowley.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbrowley.lookify.model.Song;
import com.mbrowley.lookify.service.SongService;

@Controller
@RequestMapping("/")
public class SongController {
	
	@Autowired
	private SongService sService;
	
	//title page
	@GetMapping("")
	public String index() {
		return "/index.jsp";
	}
	
	//music page
	@GetMapping("dashboard")
	public String dashboard(Model viewModel) {
		List<Song> songs = sService.getAllSongs();
		viewModel.addAttribute("songs", songs);
		return "/dashBoard.jsp";
	}
	@GetMapping("song/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/new.jsp";
	}
	
	@PostMapping("song/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/new.jsp";
		}else {
			sService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("song/{id}")
	public String songDetails(@PathVariable("id") Long id, Model viewModel) {
		Song song = sService.getOneSong(id);
		if(song != null) {
			viewModel.addAttribute("song", song);
			return "/show.jsp";
		}else {
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("search")
	public String searchArtist(@RequestParam("artist") String artist, Model viewModel) {
		List<Song> songs =sService.searchArtist(artist);
		if(songs != null) {
			viewModel.addAttribute("songs", songs);
			return "/showArtist.jsp";
		}else {
			return "redirect:/dashboard";
		}		     
	}
	
	@GetMapping("topTen")
	public String topTen(Model viewModel) {
		List<Song> songs = sService.getTopTenSongs();
		viewModel.addAttribute("songs", songs);
		return "/topTen.jsp";
	}

	@DeleteMapping("delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		sService.deleteSong(id);
		return "redirect:/dashboard";
	}
}
