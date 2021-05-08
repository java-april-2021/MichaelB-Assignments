package com.mbrowley.ProductAndCategories.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mbrowley.ProductAndCategories.model.Category;
import com.mbrowley.ProductAndCategories.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

		List<Product> findAll();
		
		List<Product> findByCategoriesNotContains(Category category);
}
