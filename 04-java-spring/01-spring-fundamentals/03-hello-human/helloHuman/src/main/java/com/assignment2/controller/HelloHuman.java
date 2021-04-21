package com.assignment2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHuman {

	@RequestMapping("/")
	public String helloHuman(Model viewModel) {
		viewModel.addAttribute("name", "Human");
		return "index.jsp";
	}
	
	@RequestMapping("/{name}")
	public String helloName(@PathVariable("name")String name, Model viewModel) {
		viewModel.addAttribute("name", name);
		return "index.jsp";
	}
}
