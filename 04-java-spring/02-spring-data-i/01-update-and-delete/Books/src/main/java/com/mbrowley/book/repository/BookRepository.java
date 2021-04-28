package com.mbrowley.book.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.book.model.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	//retrieves all books
	List<Book> findAll();
	
//	//find book by description
//	List<Book> findByDescriptionContaining(String search);
//	
//	//This method counts how many title contain a certain String
//	Long countByTitleContaining(String search);
//	
//	// deleted a boo that starts with a specific title
//	Long deleteByTitleStaartingWith(String search);
	

}
