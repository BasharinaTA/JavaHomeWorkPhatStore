package com.example.javahomeworkphatstore.service;

import com.example.javahomeworkphatstore.model.entities.Brand;
import com.example.javahomeworkphatstore.model.entities.Category;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.repository.BrandRepository;
import com.example.javahomeworkphatstore.repository.CategoryRepository;
import com.example.javahomeworkphatstore.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DataService {
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;

    public void generateBrands() {
        brandRepository.save(new Brand("Kangol"));
        brandRepository.save(new Brand("Proclub"));
        brandRepository.save(new Brand("Novesta"));
        brandRepository.save(new Brand("Hublot"));
        brandRepository.save(new Brand("Pinko"));
    }

    public void generateCategories() {
        categoryRepository.save(new Category("Головные уборы"));
        categoryRepository.save(new Category("Одежда"));
        categoryRepository.save(new Category("Обувь"));
        categoryRepository.save(new Category("Сумки"));
        categoryRepository.save(new Category("Аксессуары"));
        categoryRepository.save(new Category("Творчество"));
    }

    public void loadItems() {
        try(Stream<String> strings = Files.lines(Paths.get("kangol.txt"))) {
            List<String> list = strings.map(s -> s.replaceAll(";", "")
                            .replace("(", "")
                            .replace(")", "")).toList();
            for (String data : list) {
                String[] dataArray = data.split(", ");
                String brandName = dataArray[1];
                String categoryName = dataArray[2];
                String model = dataArray[3];
                int price = Integer.parseInt(dataArray[4]);

                Brand brand = brandRepository.findByName(brandName).get();
                Category category = categoryRepository.findByName(categoryName).get();
                Item item = new Item(model, price, brand, category);
                itemRepository.save(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
