package com.mbrowley.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbrowley.languages.model.Language;
import com.mbrowley.languages.repository.languageRepo;

@Service
public class LanguageService {
	
	private languageRepo langRepo;
	
	public LanguageService(languageRepo langRepo){
		this.langRepo = langRepo;
	}
	
	//get one language
	public List<Language> getAllLanguages(){
		return this.langRepo.findAll();
	}
	
	//get one book
	public Language getOnelang(Long id) {
		
		return this.langRepo.findById(id).orElse(null);
	}
	
	//create book
	public Language createLang(Language newLang) {
		return this.langRepo.save(newLang);
	}
	
	//delete
	public void deleteLang(Long id) {
		this.langRepo.deleteById(id);
	}
	
	//update book
	public Language updateLang(Language updatelang) {
		return this.langRepo.save(updatelang);
	}
	
	
	
}
