package com.example.javahomeworkphatstore.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    public List<String> completeCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Головные уборы");
        categories.add("Одежда");
        categories.add("Обувь");
        categories.add("Сумки");
        categories.add("Аксессуары");
        categories.add("Творчество");
        return categories;
    }

    public List<String> completeBrands() {
        List<String> brand = new ArrayList<>();
        brand.add("Kangol");
        brand.add("Proclub");
        brand.add("Novesta");
        brand.add("Hublot");
        brand.add("Pinko");
        return brand;
    }
}
