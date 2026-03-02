package com.capgemini.Assignment2_26thfeb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.Assignment2_26thfeb.dao.CategoryJpaRepository;
import com.capgemini.Assignment2_26thfeb.dto.Category;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryJpaRepository categoryRepo;

	public CategoryController(CategoryJpaRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@PostMapping("/create")
	public Category createCategory(@RequestBody Category category) {
		return categoryRepo.save(category);

	}

	@GetMapping("/view")
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Category> getCategory(@PathVariable int id) {
		return categoryRepo.findById(id);
	}

	@PutMapping("update/{id}")
	public Category updateCategory(@PathVariable int id, @RequestBody Category newCategory) {

		Category category = categoryRepo.findById(id).get();

		category.setCategoryName(newCategory.getCategoryName());
		category.setDescription(newCategory.getDescription());

		return categoryRepo.save(category);
	}
	
	@DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryRepo.deleteById(id);
        return "Category Deleted Successfully";
    }
	
//	@GetMapping("/categories/{page}/{size}")
//	public List<Category> getCategory(@PathVariable int page, @PathVariable int size) {
//		Page<Category> p = categoryRepo.findAll(PageRequest.of(page, size));
//		return p.getContent();
//		
//	}
	
	
	@GetMapping("/categories/{page}/{size}")
	public List<Category> getCategory(@PathVariable int page, @PathVariable int size,String field) {
		Page<Category> p = categoryRepo.findAll(PageRequest.of(page, size,Sort.by("id").descending()));
		return p.getContent();
		
	}

}
