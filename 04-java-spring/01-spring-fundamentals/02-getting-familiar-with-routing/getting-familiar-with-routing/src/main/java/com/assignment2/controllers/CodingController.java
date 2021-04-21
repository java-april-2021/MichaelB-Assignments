package com.assignment2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/coding")
	public String hello(){
	return "Help Comding Dojo";	
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
