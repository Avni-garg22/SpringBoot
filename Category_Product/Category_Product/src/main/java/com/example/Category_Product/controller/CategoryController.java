package com.example.Category_Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Category_Product.dto.Category;
import com.example.Category_Product.repo.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryjpa;

    //  Add Category
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category c) {
        return categoryjpa.save(c);
    }

    //Pagination + Sorting
    @GetMapping("/categories/{page}/{size}")
    public List<Category> getCategory(@PathVariable int page,
                                      @PathVariable int size) {

        Page<Category> p = categoryjpa.findAll(
                PageRequest.of(page, size, Sort.by("id").descending())
        );

        return p.getContent();
    }

    // Get By Id with ResponseEntity
    @GetMapping("/get-id/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {

        Optional<Category> optional = categoryjpa.findById(id);
Category c=null;
        if (optional.isPresent()) {
        	c=optional.get();
            return new ResponseEntity<Category>(
                    c,
                    HttpStatus.FOUND
            );
        } else {
            return new ResponseEntity<Category>(
                    c,
                    HttpStatus.NOT_FOUND
            );
        }
    }
}