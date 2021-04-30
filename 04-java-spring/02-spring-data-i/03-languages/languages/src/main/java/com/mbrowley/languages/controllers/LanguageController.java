package com.mbrowley.languages.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbrowley.languages.model.Language;
import com.mbrowley.languages.services.LanguageService;

@Controller
@RequestMapping("/")
public class LanguageController {

	@Autowired
	private LanguageService langService;
	
	//main language page
	@GetMapping("languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> langs = langService.getAllLanguages();
		model.addAttribute("langs", langs);
		return "/index.jsp";
	}
	
	//add a language
	@PostMapping("languages")
	public String addLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Language> langs = langService.getAllLanguages();
			viewModel.addAttribute("langs", langs);
			return "/index.jsp";
		}else {
			langService.createLang(language);
			return "redirect:languages";
		}
		
	}

	//edit page
	@GetMapping("languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		Language lang = langService.getOnelang(id);
		if(lang != null){
			viewModel.addAttribute("language", lang);
			return "/edit.jsp";
		}else {		
			return "redirect:/languages";
		}	
	}
	
	//saves edits to languages
	@PutMapping("languages/{id}")
	public String updateLang(@PathVariable("id") Long id, Language language) {
		this.langService.updateLang(language);
		return "redirect:/languages";
	}
	
	
	@DeleteMapping("language/{id}")
	public String deleteBookByindex(@PathVariable("id") Long id){
		this.langService.deleteLang(id);
		return "redirect:/languages";
	}
		
	
	//Show language
	@GetMapping("languages/{id}")
	public String showLang(@PathVariable("id") Long id, Model viewModel) {
		Language lang = langService.getOnelang(id);
		if(lang != null) {
			viewModel.addAttribute("lang", lang);
			return "/show.jsp";
		}else {
			return "redirect:/languages";
		}
	}
	
}
