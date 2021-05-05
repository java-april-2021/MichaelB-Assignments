package com.mbrowley.DojosAndNinjas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbrowley.DojosAndNinjas.model.Dojo;
import com.mbrowley.DojosAndNinjas.model.Ninja;
import com.mbrowley.DojosAndNinjas.service.DNService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private DNService dService;
	//title page
	@GetMapping("")
	public String index( Model viewModel){
		List<Ninja> ninjas = dService.findNinjas();
		viewModel.addAttribute("ninjas", ninjas);
		return "index.jsp";
	}
	
	@GetMapping("dojo/{id}")
	public String dojoStudent(@PathVariable("id") Long id, Model viewModel) {
		Dojo dojo = dService.getDojo(id);
		viewModel.addAttribute("dojo", dojo);
		return "/DojoRoster.jsp";
	}
	
	// add dojo form 
	@GetMapping("dojo/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo, Model viewModel){
		return "dojo.jsp";
	}
	
	//add ninja form
	@GetMapping("ninja/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		List<Dojo> dojos = dService.findDojos();
		viewModel.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	// create a dojo object
	@PostMapping("dojo/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojo/new";
		}else{
			dService.saveDojo(dojo);
			return "redirect:/";
		}
	}
	
	//create a ninja object
	@PostMapping("ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninja/new";
		}else {
			dService.saveNinja(ninja);
			return "redirect:/";
		}
		
	}
	
}
