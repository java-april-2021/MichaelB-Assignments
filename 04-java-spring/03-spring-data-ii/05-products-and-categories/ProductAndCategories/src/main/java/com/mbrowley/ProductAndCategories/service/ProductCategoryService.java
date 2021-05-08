package com.mbrowley.ProductAndCategories.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbrowley.ProductAndCategories.model.Category;
import com.mbrowley.ProductAndCategories.model.Product;
import com.mbrowley.ProductAndCategories.repository.CategoryRepository;
import com.mbrowley.ProductAndCategories.repository.ProductRepository;

@Service
public class ProductCategoryService {
	
	private final CategoryRepository cRepo;
	private final ProductRepository pRepo;
	
	public ProductCategoryService(CategoryRepository cRepo, ProductRepository pRepo) {
		this.cRepo = cRepo;
		this.pRepo = pRepo;
	}
	
	//find all categories
	public List<Category> allCategories(){
		return cRepo.findAll();
	}
	
	//find all products
	public List<Product> allProducts(){
		return pRepo.findAll();
	}
	
	//find a single category
	public Category singleCategory(Long id) {
		return cRepo.findById(id).orElse(null);
	}
	
	//find a PRODUCT
	public Product singleProduct(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	//category not in the following product
	public List<Product> catNotIn(Category category){
		return pRepo.findByCategoriesNotContains(category);
	}
	
	//products not in the follow categories
	public List<Category> ProdNotIn(Product product){
		return cRepo.findByProductsNotContains(product);
	}
	//save product
	public Product saveProduct(Product product) {
		return pRepo.save(product);
	}
	
	//save category
	public Category saveCategory(Category category) {
		return cRepo.save(category);
	}
	
	//delete category by id
	public void delCateogry(Long id) {
		cRepo.deleteById(id);;
	}
	//delete product by id
	public void delProduct(Long id) {
		pRepo.deleteById(id);
	}
	
	// add a category to product
	public void addCategory(Category category, Product product) {
		///get the list of cats
		List<Category> cats = product.getCategories();
		//add category to the list
		cats.add(category);
		//update list in DB
		this.pRepo.save(product);
		
	}
	//add a product to a category
	public void addProduct(Category category, Product product) {
		//get list of product
		List<Product> prods = category.getProducts();
		//add category for list
		prods.add(product);
		//save the category
		this.cRepo.save(category);
	}
}
