package com.mbrowley.EventsBeltViewer.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbrowley.EventsBeltViewer.model.Comment;
import com.mbrowley.EventsBeltViewer.model.Event;
import com.mbrowley.EventsBeltViewer.model.State;
import com.mbrowley.EventsBeltViewer.model.User;
import com.mbrowley.EventsBeltViewer.service.EventService;
import com.mbrowley.EventsBeltViewer.service.UserService;

@Controller
@RequestMapping("/")
public class EventsContoller {

	@Autowired
	private UserService uService;
	
	@Autowired
	private EventService eService;

	public Long userSession(HttpSession session) {
		if(session.getAttribute("userId") == null) { 
			return null;
		} 
		return (Long)session.getAttribute("userId"); }

	
	        //events page
	@GetMapping("events")
	public String events(@ModelAttribute("event") Event event, Model viewModel, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = uService.findUserById(userSession(session));
		viewModel.addAttribute("InState", eService.inState(user.getState()));
		viewModel.addAttribute("outOfState", eService.outOfState(user.getState()));
		viewModel.addAttribute("states", State.state);
		viewModel.addAttribute("user", user);
		return "events.jsp";
	}
	//save the event
	@PostMapping("events")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model viewModel, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			User user = uService.findUserById(userSession(session));
			viewModel.addAttribute("InState", eService.inState(user.getState()));
			viewModel.addAttribute("outOfState", eService.outOfState(user.getState()));
			viewModel.addAttribute("states", State.state);
			viewModel.addAttribute("user", user);
			return "events.jsp";
		}else{	
			eService.saveEvent(event);
			return "redirect:/events";
		}
	}
	
	//get a specific event
	@GetMapping("events/{id}")
	public String getEvent(@PathVariable("id") Long id, @ModelAttribute("comment") Comment comment, Model viewModel, HttpSession session) {
		userSession(session);
		Event event = eService.getEvent(id);
		User user = uService.findUserById(userSession(session));
		List<Comment> comm =  eService.getEvent(id).getComments();
		viewModel.addAttribute("user", comm);
		viewModel.addAttribute("event", event);
		return "show.jsp";
	}
	//adds an event
	@PostMapping("events/{id}")
	public String postComment(@PathVariable("id") Long id, @RequestParam("comment") String comment, RedirectAttributes redirs, Model viewModel, HttpSession session) {
		if(userSession(session) == null){
			return "redirect:/";
		}
		Event event = eService.getEvent(id);
        User user = uService.findUserById(userSession(session));
        this.eService.saveComment(event, user, comment);
        return "redirect:/events/" + id;
	}
	//get an event to update
	@GetMapping("events/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model viewModel, HttpSession session){
		User user = uService.findUserById(userSession(session));
		Event editEvent = eService.getEvent(id);
		if(userSession(session) == null) {
			return "redirect:/";
		}
		if(editEvent == null || !editEvent.getOrganizier().getId().equals(user.getId())){
			return "redirect:/events";
		}
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("event", editEvent);
		viewModel.addAttribute("states", State.state);
		return "edit.jsp";
	}
	
	//updates an event
	@PutMapping("events/{id}/edit")
	public String editEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model viewModel){
		
		if(userSession(session) == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Event editEvent = eService.getEvent(id);
			viewModel.addAttribute("user", userSession(session));
			viewModel.addAttribute("event", editEvent);
			viewModel.addAttribute("states", State.state);
			return "edit.jsp";
		}else {
			eService.saveEvent(event);
			return "redirect:/events";
		}
	}
	
	//deletes an event
	@PostMapping("events/del/{id}")
	public String deleteEvent(@PathVariable("id") Long id) {
		Event event = eService.getEvent(id);
			eService.delEventCleanUp(event);
			eService.deleteEvent(id);
			return "redirect:/events";

	}
	
	//add attendee for event
	@PostMapping("events/add/{id}")
	public String addAttendee(@PathVariable("id") Long id, HttpSession session) {
		Event event = eService.getEvent(id);
		User user = uService.findUserById(userSession(session));
		if(event.getId() == null || userSession(session) == null) {
			return "redirect:/";
		}
		if(event.getAttendees().contains(user)) {
			return "redirect:/events";
		}
		eService.addAttendee(event, user);
		return "redirect:/events";
	}
	
	//remove the attendee for event
	@PostMapping("events/remove/{id}")
	public String removeAttendee(@PathVariable("id") Long id, HttpSession session) {
		Event event = eService.getEvent(id);
		User user = uService.findUserById(userSession(session));
		if(event.getId() == null || userSession(session) == null) {
			return "redirect:/";
		}
		if(!event.getAttendees().contains(user)) {
			return "redirect:/events";
		}
		eService.removeAttendee(event, user);
		return "redirect:/events";
	}
}
