package com.mbrowley.EventsBeltViewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbrowley.EventsBeltViewer.model.Comment;
import com.mbrowley.EventsBeltViewer.model.Event;
import com.mbrowley.EventsBeltViewer.model.User;
import com.mbrowley.EventsBeltViewer.repository.CommentRepository;
import com.mbrowley.EventsBeltViewer.repository.EventRepository;


@Service
public class EventService {
	
	@Autowired
	private EventRepository eRepo;
	
	@Autowired 
	private CommentRepository cRepo;	
	
	
	//get all events
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
	}
	
	//get one event
	public Event getEvent(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	//in state events
	public List<Event> inState(String state){
		return this.eRepo.findByState(state);
	}
	
	//out of state events
	public List<Event> outOfState(String state){
		return this.eRepo.findByStateIsNot(state);
	}
	
	//save event
	public void saveEvent(Event event) {
		this.eRepo.save(event);
	}
	
	//delete comments
	public void delEventCleanUp(Event event) {
		//get comments and attendees
		List<User> users = event.getAttendees();
		List<Comment> comments = event.getComments();
		// delete all comments
		comments.clear();
		users.clear();
		this.eRepo.save(event);
	}
	
	//delete event
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	//add a comment to an event
	public void addAttendee(Event event, User user){
		//get attendees from event
		List<User> attendees = event.getAttendees();
		//add attendee to event
		attendees.add(user);
		//save the event with new attendee
		this.eRepo.save(event);
		
	}
	
	//remove attendee from an event
	public void removeAttendee(Event event, User user) {
		//get attendee from event
		List<User> attendees = event.getAttendees();
		//remove attendees
		attendees.remove(user);
		//save the event with new attendee
		this.eRepo.save(event);
	}
	
	public void saveComment(Event event, User user,  String comment) {
		this.cRepo.save(new Comment(event, user, comment));
	}
	
	
	
}
