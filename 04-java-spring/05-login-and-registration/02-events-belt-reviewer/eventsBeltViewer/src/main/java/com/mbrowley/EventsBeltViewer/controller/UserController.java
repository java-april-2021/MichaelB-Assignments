package com.mbrowley.EventsBeltViewer.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbrowley.EventsBeltViewer.model.State;
import com.mbrowley.EventsBeltViewer.model.User;
import com.mbrowley.EventsBeltViewer.service.UserService;
import com.mbrowley.EventsBeltViewer.validation.UserValidator;

@Controller 
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService uService;
	

	@Autowired
	private UserValidator validator;
	
	
	                   /* Authenication */
	//registration page
	@GetMapping("")
	public String index(@ModelAttribute("register") User register, Model viewModel) {
		viewModel.addAttribute("states", State.state);
		return "index.jsp";
	}
	
	//register user
	@PostMapping("register")
	public String register(@Valid @ModelAttribute("register") User register, BindingResult result, Model viewModel ) {
		validator.validate(register, result);
		if(result.hasErrors()) {
			viewModel.addAttribute("states", State.state);
			return "index.jsp";
		}else {
			uService.registerUser(register);
			return "redirect:/";
		}
	}
	//login
	@PostMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirs) {
		if(uService.authenicateUser(email, password)) {
			session.setAttribute("userId", uService.findUserByEmail(email).getId());
			return "redirect:/events";
		}
		redirs.addFlashAttribute("error", "Invalid credentials");
		return "redirect:/";
	}
	
	//logout
	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	public Long userId(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return null;
		}
		return (Long)session.getAttribute("userId");
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
