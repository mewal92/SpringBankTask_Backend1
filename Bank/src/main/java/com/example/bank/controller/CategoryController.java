package com.example.bank.controller;

import com.example.bank.models.Category;
import com.example.bank.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@AllArgsConstructor
public class CategoryController {


    private final CategoryRepository categoryRepository;


    @RequestMapping("categories/add")
    public String addKategori(@RequestParam String namn) {
        categoryRepository.save(new Category(namn));
        return "Kategori "+namn+" lades till";
    }

    @RequestMapping("categories/delete/{id}")
    public String deleteKategori(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return "kategori "+id+" togs bort";
    }

    @RequestMapping("category")
    public Category getCategoryById(@RequestParam Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @RequestMapping("categories")
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @PostMapping("/categories/addByPost")
    public String addBookByPOST(@RequestBody Category c){
       categoryRepository.save(c);
        return "Kategori "+c.getName()+" lades till";
    }



}
