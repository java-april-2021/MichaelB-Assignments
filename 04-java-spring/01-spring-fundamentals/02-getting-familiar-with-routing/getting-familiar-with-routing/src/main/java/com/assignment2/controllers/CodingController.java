package com.assignment2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodingController {
	@RequestMapping("/coding")
	public String hello(){
	return "index.jsp";	
	}
	@RequestMapping("/coding/python")
	public String helloPython() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("coding/java")
	public String heloJava() {
		return "Java/Spring is better!";
	}
}
