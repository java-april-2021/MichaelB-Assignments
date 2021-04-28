package com.mbrowley.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbrowley.book.model.Book;
import com.mbrowley.book.service.BookService;

@RestController
public class BooksApi {
	@Autowired
	private BookService bService;
	
	@RequestMapping("/")
	public List<Book> index(){
		return this.bService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getTeam(@PathVariable("id") Long id) {
		return this.bService.getOneBook(id);
	}
	
	@PostMapping("/add")
	public Book create(Book newBook) {
		return this.bService.createBook(newBook);
	}
	
	@DeleteMapping("/book/{id}")
	public String removeBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
		return id + "removed";
	}
	
	
}
