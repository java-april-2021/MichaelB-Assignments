package com.mbrowley.ProductAndCategories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbrowley.ProductAndCategories.model.Category;
import com.mbrowley.ProductAndCategories.model.Product;
import com.mbrowley.ProductAndCategories.service.ProductCategoryService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ProductCategoryService pcService;

	// main page
	@GetMapping("")
	public String index(Model viewModel) {
		List<Product> prods = pcService.allProducts();
		List<Category> cats = pcService.allCategories();
		viewModel.addAttribute("prods", prods);
		viewModel.addAttribute("cats", cats);
		return "index.jsp";
	}

	// add a product form
	@GetMapping("product")
	public String productForm(@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}

	// add a category form
	@GetMapping("category")
	public String categoryForm(@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	// create product
	@PostMapping("product/new")
	public String createProduct(@ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/product";
		} else {
			pcService.saveProduct(product);
			return "redirect:/";
		}
	}
	// create a category
	@PostMapping("category/new")
	public String createCategory(@ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct.jsp";
		} else {
			pcService.saveCategory(category);
			return "redirect:/";
		}
	}
	// add category to product
	@GetMapping("product/{id}")
	public String addCategory(@PathVariable("id") Long id, Model viewModel) {
		Product prod = pcService.singleProduct(id);
		List<Category> cats = pcService.ProdNotIn(prod);
		viewModel.addAttribute("prod", prod);
		viewModel.addAttribute("cats", cats);
		return "addCategories.jsp";
	}
	//add a product to a category
	@GetMapping("category/{id}")
	public String addProductForm(@PathVariable("id") Long id, Model viewModel) {
		Category cat = pcService.singleCategory(id);
		List<Product> prods = pcService.catNotIn(cat);
		viewModel.addAttribute("cat",cat);
		viewModel.addAttribute("prods", prods);
		return "addProducts.jsp";
	}
	// delete a product
	@PostMapping("product/delete/{id}")
	public String delProduct(@PathVariable("id") Long id) {
		pcService.delProduct(id);
		return "redirect:/";
	}

	// delete category
	@PostMapping("category/delete/{id}")
	public String delCategory(@PathVariable("id") Long id) {
		pcService.delCateogry(id);
		return "redirect:/";
	}

	 //add a category to a project
	  @PostMapping("product/add")
	  public String addCategoryToProduct(@RequestParam("category_id") Long CatId, @RequestParam("product_id") Long proId){ 
		  Product prod = pcService.singleProduct(proId);
		  Category cat = pcService.singleCategory(CatId); 
		  pcService.addCategory(cat, prod);
		  return "redirect:/";
	  }
	 //add a category to a project
	  @PostMapping("category/add")
	  public String addProductToCategory(@RequestParam("category_id") Long catId, @RequestParam("product_id") Long proId) {
		  Product prod = pcService.singleProduct(proId);
		  Category cat = pcService.singleCategory(proId);
		  pcService.addProduct(cat, prod);
		  return "redirect:/";
	  }
}
