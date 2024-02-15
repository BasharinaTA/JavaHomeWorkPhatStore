package com.example.javahomeworkphatstore.repository;

import com.example.javahomeworkphatstore.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);

    Category findById(int id);
}
