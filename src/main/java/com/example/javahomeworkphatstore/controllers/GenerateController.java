package com.example.javahomeworkphatstore.controllers;

import com.example.javahomeworkphatstore.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/serv")
public class GenerateController {
    private DataService dataService;

    @GetMapping("/generate")
    public void generate() {
        dataService.generateBrands();
        dataService.generateCategories();
    }
    @GetMapping("/load")
    public void load() {
        dataService.loadItems();
    }
}
