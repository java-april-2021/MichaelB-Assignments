package com.books.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.books.mvc.models.Book;
import com.books.mvc.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books")
	public String index(Model viewModel) {
		List<Book> books = bookService.allBooks();
		viewModel.addAttribute("books", books);
		return "/books/index.jsp";
		
	}
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model viewModel, @PathVariable("index") int index){
		Book book = bookService.findBookByIndex(index);
		viewModel.addAttribute("book", book);
		return "showBook.jsp";
	}
	@RequestMapping("books/new")
	public String newBook() {
			return "/books/new.jsp";
		
	}

}
