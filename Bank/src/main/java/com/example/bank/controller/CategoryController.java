package com.example.bank.controller;

import com.example.bank.models.Category;
import com.example.bank.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping("/add/{category}")
    public String createCategory(@PathVariable String category) {
        Category c = new Category();
        c.setCategory(category);
        categoryRepository.save(c);
        return "Category " + category + " created";
    }

    @GetMapping("/get/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryRepository.findById(id).get();
    }
}
