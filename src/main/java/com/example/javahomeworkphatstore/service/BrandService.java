package com.example.javahomeworkphatstore.service;

import com.example.javahomeworkphatstore.model.entities.Brand;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class BrandService {
    private BrandRepository brandRepository;

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }

    public Brand getById(int id) {
        return brandRepository.findById(id);
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand update(Brand brand) {
        if (brandRepository.findById(brand.getId()).isPresent()) {
            brandRepository.save(brand);
        }
        return brand;
    }

    public Brand deleteById(int id) {
        Brand brand = brandRepository.findById(id);
        brandRepository.deleteById(id);
        return brand;
    }

    public Brand getByName(String name) {
        return brandRepository.findByName(name).orElse(null);
    }

    public Set<Item> getItemsByName(String name) {
        return brandRepository.findByName(name).map(Brand::getItems)
                .orElse(Collections.emptySet());
    }

    public Brand deleteByName(String name) {
        Optional<Brand> brand = brandRepository.findByName(name);
        brand.ifPresent(value -> brandRepository.delete(value));
        return brand.orElse(null);
    }

    public void deleteAll() {
        brandRepository.deleteAll();
    }
}
