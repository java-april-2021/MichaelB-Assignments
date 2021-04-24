package com.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {


	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/processData")
	public String procData(@RequestParam(value = "name") String name, @RequestParam(value = "location") String location, @RequestParam("lang") String lang, @RequestParam("comment") String comment, Model viewModel, RedirectAttributes rAttribute ) {
		rAttribute.addFlashAttribute("name", name );
		rAttribute.addFlashAttribute("location", location);
		rAttribute.addFlashAttribute("lang", lang);
		rAttribute.addFlashAttribute("comment", comment);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result(@ModelAttribute("name") String name, @ModelAttribute("location") String location, @ModelAttribute("lang") String lang, @ModelAttribute("comment") String comment) {
		return "/result.jsp";
	}
}