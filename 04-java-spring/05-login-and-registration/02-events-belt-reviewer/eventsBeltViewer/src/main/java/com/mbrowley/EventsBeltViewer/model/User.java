package com.mbrowley.EventsBeltViewer.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email(message="Please enter a valid email address")
	private String email;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;
	
	@NotBlank
	@Size(min=8, message="Password must be at least 8 Characters")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
	private Date createdAt;
	
	private Date updatedAt;
	
	
	//constructor
	public User() {
		
	}
	
	//comment relationship
	@OneToMany(mappedBy="commentor", fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	//event creator relationship
	@OneToMany(mappedBy="organizier", fetch=FetchType.LAZY)
	private List<Event> organiziedEvents;

	
	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<Event> getOrganiziedEvents() {
		return organiziedEvents;
	}



	public void setOrganiziedEvents(List<Event> organiziedEvents) {
		this.organiziedEvents = organiziedEvents;
	}



	public List<Event> getEvents() {
		return events;
	}



	public void setEvents(List<Event> events) {
		this.events = events;
	}

	//event attendee relationship
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<Event> events;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}



	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	protected void onupdate() {
		this.updatedAt = new Date();
	}
}
