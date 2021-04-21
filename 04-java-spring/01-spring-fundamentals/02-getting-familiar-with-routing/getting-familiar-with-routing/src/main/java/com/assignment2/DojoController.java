package com.assignment2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {
	
	@RequestMapping("/dojo")
	public String dojo(){
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/dojo/{location}")
	public String dojoCenter(@PathVariable("location") String location, Model viewmodel){
		viewmodel.addAttribute("dojoname", location);
		switch(location) {
		
		case "burbank":
			return "index.jsp";
			
		case "san-jose":
			return "index.jsp";
			
		default:
			return "index.jsp";
		}
	}
}
