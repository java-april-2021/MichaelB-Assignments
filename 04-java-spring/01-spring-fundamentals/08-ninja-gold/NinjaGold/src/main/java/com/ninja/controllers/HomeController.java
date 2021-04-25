package com.ninja.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(HttpSession session, Model viewModel) {
//		session.setAttribute("gold", 0);
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null){
		   session.setAttribute("gold", 0);
		   }
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activity", session.getAttribute("activity"));
		return "index.jsp";
	}
	@PostMapping("/processGold")
	public String gold(@RequestParam("building") String building, HttpSession session) {
		int newGold;
		int oldGold = (int)session.getAttribute("gold");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd YYYY h:mma");
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		Random gold = new Random();
		switch(building) {
			case "farm": 
				newGold = gold.nextInt((20 - 10) + 1) + 10;
				activity.add(String.format("You entered a %s and earned %d gold %s \n", building, newGold, format.format(now)));
				break;
			case "cave": 
				newGold = gold.nextInt((10 - 5) + 1) + 5;
				activity.add(String.format("You entered a %s and earned %d gold %s \n", building, newGold, format.format(now)));
				break;
			case "house": 
				newGold = gold.nextInt((5-2) + 1) + 2;
				activity.add(String.format("You entered a %s and earned %d gold %s \n", building, newGold, format.format(now)));
				break;
			default:
				newGold = gold.nextInt((50 + 50) + 1) - 50;
				if(newGold > 0) {
					activity.add(String.format("You entered a %s and earned %d gold %s \n", building, newGold, format.format(now)));
				}else {
					activity.add(String.format("You entered a %s and lost %d gold ouch! %s \n", building, newGold, format.format(now)));
				}
				
				break;
		}
		int totalGold = oldGold += newGold;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activity", activity);
		return "redirect:/";
		
	}	

}