package com.example.Category_Product.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Category_Product.dto.Category;



public interface CategoryRepository extends JpaRepository<Category, Integer>{

}