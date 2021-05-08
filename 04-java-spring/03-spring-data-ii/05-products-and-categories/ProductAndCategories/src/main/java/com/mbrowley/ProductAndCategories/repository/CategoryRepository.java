package com.mbrowley.ProductAndCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.ProductAndCategories.model.Category;
import com.mbrowley.ProductAndCategories.model.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>  {
	List<Category> findAll();
	
	List<Category> findByProductsNotContains(Product product);
}
