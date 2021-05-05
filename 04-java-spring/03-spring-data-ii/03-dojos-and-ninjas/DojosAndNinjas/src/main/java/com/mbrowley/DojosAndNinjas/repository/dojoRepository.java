package com.mbrowley.DojosAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mbrowley.DojosAndNinjas.model.Dojo;

public interface dojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
	
	Dojo findByNameContaining(String Search);
}
