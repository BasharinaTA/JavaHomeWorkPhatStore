package com.example.javahomeworkphatstore.controllers;

import com.example.javahomeworkphatstore.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ViewController {
    private StoreService storeService;

    @GetMapping("/onLoadIndex")
    public Map<String, List<String>> onLoadIndex() {
        Map<String, List<String>> result = new HashMap<>();
        result.put("categories", storeService.completeCategories());
        result.put("brands", storeService.completeBrands());
        return result;
    }
}
