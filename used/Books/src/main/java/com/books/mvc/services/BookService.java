package com.books.mvc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.books.mvc.models.Book;
import com.books.mvc.repositories.BookRepository;


@Service
public class BookService {
	private final BookRepository bookRepository;
	private List<Book> books = new ArrayList(Arrays.asList(
			new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309),
			new Book ("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180 ),
			new Book("Moby Dick", "The saga of Captain Ahab", "english", 544),
			new Book("Don Quixote", "Life of a retired country gentleman", "english", 150),
			new Book("The Odyssey", "Ancient Greek epic poem", "english", 475)));
	
	public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
	
	//return all the books
	public List<Book>allBooks() {
        return bookRepository.findAll();
    }
	
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
		
		
	}
	public Book findBookByIndex(int index) {
        if (index < books.size()){
            return books.get(index);
        }else{
            return null;
        }
    }
}
