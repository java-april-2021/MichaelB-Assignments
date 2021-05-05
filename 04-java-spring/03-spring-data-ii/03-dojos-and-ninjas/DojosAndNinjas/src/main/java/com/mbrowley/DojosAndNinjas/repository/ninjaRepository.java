package com.mbrowley.DojosAndNinjas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mbrowley.DojosAndNinjas.model.Ninja;

public interface ninjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	
}
