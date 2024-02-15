package com.example.javahomeworkphatstore.controllers;

import com.example.javahomeworkphatstore.model.entities.Brand;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/brands")
@AllArgsConstructor
public class BrandController {
    private BrandService brandService;

    @GetMapping("/all")
    public List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/id/{id}")
    public Brand getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Brand getByName(@PathVariable String name) {
        return brandService.getByName(name);
    }

    @GetMapping("/items/{name}")
    public Set<Item> getItemsByName(@PathVariable String name) {
        return brandService.getItemsByName(name);
    }

    @PostMapping("/delete/id/{id}")
    public Brand deleteById(@PathVariable int id) {
        return brandService.deleteById(id);
    }

    @PostMapping("/delete/name/{name}")
    public Brand deleteByName(@PathVariable String name) {
        return brandService.deleteByName(name);
    }

    @PostMapping("/delete/all")
    public void deleteAll() {
        brandService.deleteAll();
    }
 }
