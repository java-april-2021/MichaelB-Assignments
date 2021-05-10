package com.mbrowley.DojoOverFlow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.DojoOverFlow.model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long>{
	
	List<Answer> findAll();

}
