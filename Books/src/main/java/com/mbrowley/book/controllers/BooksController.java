package com.mbrowley.book.controllers;

import java.util.List;

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

import com.mbrowley.book.model.Book;
import com.mbrowley.book.service.BookService;

@Controller
public class BooksController {
	
	@Autowired
	private BookService bService;
	
	//show all books in a table
	@GetMapping("/books")
		public String index(Model model) {
			List<Book> books = bService.getAllBooks();
			model.addAttribute("books", books);
			return "/books/index.jsp";
		}
	//show a single book
	@GetMapping("/books/{index}")
	public String findBookByIndex(Model viewModel, @PathVariable("index") Long index) {
		Book book = bService.getOneBook(index);
		viewModel.addAttribute("book", book);
		return "/books/showBook.jsp";
	}
	//delete book
	@DeleteMapping("/books/delete/{index}")
	public String deleteBookByindex(Model viewModel, @PathVariable("index") Long index){
		this.bService.deleteBook(index);
		return "redirect:/books";
	}
	
	
	
	//book form
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}
	
	//creates a book
	@PostMapping("/books/create")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result){
		if (result.hasErrors()){
			return "/books/new.jsp";
		}else {
			bService.createBook(book);
			return "redirect:/books";
		}
	}
	
	//edits a book
	@GetMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bService.getOneBook(id);
		if(book != null) {
			model.addAttribute("book", book);
			return "/books/edit.jsp";
		}else {
			return "redirect:/books";
		}
	}	
	
	//save edits
	@PutMapping("books/edit/{id}")
	public String updatedBook(@PathVariable("id") Long id, Book updatedBook){
		this.bService.updateBook(updatedBook);
		return "redirect:/books";
	}
}
