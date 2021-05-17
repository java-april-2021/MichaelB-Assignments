package com.mbrowley.EventsBeltViewer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String content;
	
	@Column(updatable=false)
	private Date createAt;
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User commentor;
	
	public User getCommentor() {
		return commentor;
	}


	public void setCommentor(User commentor) {
		this.commentor = commentor;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Event event;
	
	public Comment(Event event, User commentor, String content) {
		this.content = content;
		this.event = event;
		this.commentor = commentor;
	}
	
	
	public Comment() {
		
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	@PrePersist
	protected void onCreate() {
		this.createAt = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
