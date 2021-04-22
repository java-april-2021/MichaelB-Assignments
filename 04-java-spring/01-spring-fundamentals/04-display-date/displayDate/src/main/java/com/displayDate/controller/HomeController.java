package com.displayDate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(Model model){
		Date date = new Date();
		model.addAttribute("rightNow", date);
		return "index.jsp";
	}
	
	@RequestMapping("/{dt}")
	public String DateTime(@PathVariable("dt") String dt, Model viewModel) {
		if(!dt.equals("date") && !dt.equals("time"))
		return"redirect:/";
		SimpleDateFormat dm = (dt.equals("date")) ? new SimpleDateFormat("EEEE, 'the' dd 'of' mmmm, yyyy") : new SimpleDateFormat("h:mm a");
		viewModel.addAttribute("dtFormat", dm.format(new java.util.Date()));
		viewModel.addAttribute("dt", dt);
		return "dateTime.jsp";
	}
}

