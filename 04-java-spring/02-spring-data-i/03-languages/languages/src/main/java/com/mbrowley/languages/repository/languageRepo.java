package com.mbrowley.languages.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.languages.model.Language;

@Repository
public interface languageRepo extends CrudRepository<Language, Long> {
	
	List<Language> findAll();
}
