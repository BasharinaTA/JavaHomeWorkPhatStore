package com.example.javahomeworkphatstore.repository;

import com.example.javahomeworkphatstore.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName(String name);

    Brand findById(int id);
}
