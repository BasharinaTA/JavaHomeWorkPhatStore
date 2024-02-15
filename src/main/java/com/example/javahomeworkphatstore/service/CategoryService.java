package com.example.javahomeworkphatstore.service;

import com.example.javahomeworkphatstore.model.entities.Category;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(int id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        if (categoryRepository.findById(category.getId()).isPresent()) {
            categoryRepository.save(category);
        }
        return category;
    }

    public Category deleteById(int id) {
        Category category = categoryRepository.findById(id);
        categoryRepository.deleteById(id);
        return category;
    }

    public Category getByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    public Set<Item> getItemsByName(String name) {
        return categoryRepository.findByName(name).map(Category::getItems)
                .orElse(Collections.emptySet());
    }

    public Category deleteByName(String name) {
        Optional<Category> category = categoryRepository.findByName(name);
        category.ifPresent(value -> categoryRepository.delete(value));
        return category.orElse(null);
    }

    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
