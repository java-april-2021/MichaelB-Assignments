package com.mbrowley.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbrowley.languages.model.Language;
import com.mbrowley.languages.services.LanguageService;

@RestController
public class LanguageApi {
	
	@Autowired
	private LanguageService langService;
	
	@RequestMapping("/language")
	public List<Language> index(){
		return this.langService.getAllLanguages();
	}
	
	@GetMapping("/languagesApi/{id}")
	public Language getLanguage(@PathVariable("id") Long id) {
		return this.langService.getOnelang(id);
	}
	
	@PostMapping("/language")
	public Language create(Language newLang) {
		return this.langService.createLang(newLang);
	}
	
	@DeleteMapping("/book/{id}")
	public String removeLang(@PathVariable("id") Long id) {
		this.langService.deleteLang(id);
		return id + " removed";
	}
}
