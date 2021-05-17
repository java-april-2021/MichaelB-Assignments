package com.mbrowley.EventsBeltViewer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Future
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date eventDate;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	
	
	//comment relationship
	@OneToMany(mappedBy="event", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	//organizier relationship
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User organizier;
	
	//attendee relationship
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name="event_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> attendees;
	
	
	public Event() {
		
	}
	
	public Event(String name, Date eventDate, String city, String state) {
		this.name = name;
		this.eventDate = eventDate;
		this.city = city;
		this.state = state;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public User getOrganizier() {
		return organizier;
	}


	public void setOrganizier(User organizier) {
		this.organizier = organizier;
	}


	public List<User> getAttendees() {
		return attendees;
	}


	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
