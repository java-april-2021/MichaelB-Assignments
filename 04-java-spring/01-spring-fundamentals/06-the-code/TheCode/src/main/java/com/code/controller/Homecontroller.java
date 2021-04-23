package com.code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Homecontroller {

	
	private String[] getValues() {
		return new String [] {
				"Loyalty", "Courage", "Veractiy", "Compassion", "Honor"};
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("error") String error){
		return "index.jsp";
	}
	
	@RequestMapping("/code")
	public String code(Model viewModel) {
		viewModel.addAttribute("values", getValues());
		return "code.jsp";
	}
	
	@PostMapping("/check")
	public String checkCode(@RequestParam(value="codeWord") String codeWord, Model viewModel, RedirectAttributes redirectAttr) {
		if(codeWord.equals("bushido")) {
			return "redirect:/code";
		}
		else {
			redirectAttr.addFlashAttribute("error", "You must train harder!!!" );
			return "redirect:/";
		}
	}
	
}
