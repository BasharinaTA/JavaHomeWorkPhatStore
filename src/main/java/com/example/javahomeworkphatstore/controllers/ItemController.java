package com.example.javahomeworkphatstore.controllers;

import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private ItemService itemService;

    @GetMapping("/all")
    public List<Item> getAll() {
        return itemService.getAll();
    }

    @GetMapping("/id/{id}")
    public Item getById(@PathVariable int id) {
        return itemService.getById(id);
    }

    @GetMapping("/name/{name}")
    public Item getByName(@PathVariable String name) {
        return itemService.getByName(name);
    }

    @GetMapping("/brand/{name}")
    public String getBrandByName(@PathVariable String name) {
        return itemService.getBrandByName(name);
    }

    @GetMapping("/category/{name}")
    public String getCategoryByName(@PathVariable String name) {
        return itemService.getCategoryByName(name);
    }

    @PostMapping("/delete/id/{id}")
    public Item deleteById(@PathVariable int id) {
        return itemService.deleteById(id);
    }

    @PostMapping("/delete/name/{name}")
    public Item deleteByName(@PathVariable String name) {
        return itemService.deleteByName(name);
    }

    @PostMapping("/delete/all")
    public void deleteAll() {
        itemService.deleteAll();
    }
}
