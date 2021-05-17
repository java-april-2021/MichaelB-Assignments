package com.mbrowley.EventsBeltViewer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.EventsBeltViewer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
	List<Comment> findAll();
}
