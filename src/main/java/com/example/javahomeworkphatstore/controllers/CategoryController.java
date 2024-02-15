package com.example.javahomeworkphatstore.controllers;

import com.example.javahomeworkphatstore.model.entities.Category;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/id/{id}")
    public Category getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Category getByName(@PathVariable String name) {
        return categoryService.getByName(name);
    }

    @GetMapping("/items/{name}")
    public Set<Item> getItemsByName(@PathVariable String name) {
        return categoryService.getItemsByName(name);
    }

    @PostMapping("/delete/id/{id}")
    public Category deleteById(@PathVariable int id) {
        return categoryService.deleteById(id);
    }

    @PostMapping("/delete/name/{name}")
    public Category deleteByName(@PathVariable String name) {
        return categoryService.deleteByName(name);
    }

    @PostMapping("/delete/all")
    public void deleteAll() {
        categoryService.deleteAll();
    }
}
