package com.counter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(HttpSession session) {
		// check to see if session exist
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		// get current count
		   Integer currentCount = (Integer) session.getAttribute("count");
		   //increment count by 1
		   currentCount++;
		   //update session with the new count
		   session.setAttribute("count", currentCount);	
		return "index.jsp";
	}
	
	@RequestMapping("/{num}")
	public String numTimes(@PathVariable("num") int num, HttpSession session ) {
		// check to see if session exist
				if(session.getAttribute("count") == null) {
					session.setAttribute("count", 0);
				}
		// get current count
		   Integer currentCount = (Integer) session.getAttribute("count");
		   //increment count by 1
		   currentCount +=num;
		   //update session with the new count
		   session.setAttribute("count", (currentCount - 1));	
		   return "redirect:/";
	}
	
   @RequestMapping("/counter")
   public String counter(HttpSession session, Model viewModel) {
	   // go the counted site
	   return "counter.jsp";
   }
   
   @RequestMapping("/byTwos")
   public String counter2(HttpSession session) {
	   //get current count
	   Integer currentCount = (Integer) session.getAttribute("count");
	   //increment by two
	    currentCount += 2;
	    //update session with new count
	    session.setAttribute("count", currentCount);
	   return "bytwos.jsp";
	   
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		//reset counters
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}
   
}
