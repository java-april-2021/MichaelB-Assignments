package com.books.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min = 5, max = 200)
	private String title;
	
	@Column
	@Size(min = 5, max = 200)
	private String description;
	
	@Column
	@Size(min = 3, max = 200)
	private String language;
	
	@Column
	@Min(100)
	private int numberOfPages;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	public Book() {
		
	}
	
	public Book(String title, String desc, String lang, int pages) {
		this.title = title;
		this.description = desc;
		this.language = lang;
		this.numberOfPages = pages;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
