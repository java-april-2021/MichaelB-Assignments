package com.mbrowley.DojoOverFlow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.DojoOverFlow.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	List<Question> findAll();
}
