package com.mbrowley.DojoOverFlow.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbrowley.DojoOverFlow.model.Answer;
import com.mbrowley.DojoOverFlow.model.NewQuestion;
import com.mbrowley.DojoOverFlow.model.Question;
import com.mbrowley.DojoOverFlow.service.QuestionService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private QuestionService qService;
	
	//main page
	@GetMapping("")
	public String index(Model viewModel) {
		List<Question> questions = qService.allQuestions();
		viewModel.addAttribute("questions", questions);
		return "index.jsp";
	}
	
	//  new question form
	@GetMapping("new")
	public String New(@ModelAttribute("newQuestion")NewQuestion newQuestion) {
		return "new.jsp";
	}
	
	//answer a question!!
	@GetMapping("{id}")
	public String Show(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model viewModel) {
		viewModel.addAttribute("question", this.qService.singleQuestion(id));
		return "show.jsp";
	}
	
	//create a question
	@PostMapping("")
	public String Create(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			this.qService.createQuestion(newQuestion);
			return "redirect:/";
		}
		
	}
	//create answer to a question
	@PostMapping("answers")
	public String CreateAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}else {
			this.qService.createAnswer(answer);
			return "redirect:/";
		}
		
	}
}
