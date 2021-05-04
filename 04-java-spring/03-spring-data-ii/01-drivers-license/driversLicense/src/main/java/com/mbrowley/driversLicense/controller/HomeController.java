package com.mbrowley.driversLicense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbrowley.driversLicense.model.License;
import com.mbrowley.driversLicense.model.Person;
import com.mbrowley.driversLicense.service.DMVService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private DMVService dService;
	
	//main page
	@GetMapping("")
	public String titlepage(@ModelAttribute("person") Person person, Model viewModel) {	
		List<Person> peeps = dService.allPeople();
		viewModel.addAttribute("peeps", peeps);
		return "/mainPage.jsp";
	}
	
	//add person form
	@GetMapping("person/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "/index.jsp";
	}
	
	//add license form
	@GetMapping("license/new")
	public String addLicense(@ModelAttribute("license") License license, Model viewModel) {
		List<Person> persons = dService.getUnlicensePeople();
		viewModel.addAttribute("persons", persons);
		return "license.jsp";
	}
	//add new person
	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		dService.savePerson(person);
		return "redirect:/";
	}
	//add a new license
	@PostMapping("license/new")
	public String createLicense(@ModelAttribute("license") License license, BindingResult result){
		dService.saveLicense(license);
		return "redirect:/";
	}
	@GetMapping("/person/{id}")
	public String record(@PathVariable("id") Long id, Model viewModel) {
		Person person = dService.findPerson(id);
		viewModel.addAttribute("person", person);
		return "/person.jsp";
	}
	
	
	

}
