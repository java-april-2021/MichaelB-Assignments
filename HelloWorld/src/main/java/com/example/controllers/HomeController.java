package com.example.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	//Declare the endpoint
	@RequestMapping("/")
	//method that maps the requrest above
	public String hello() {
		return "Hello World";
	}
}
