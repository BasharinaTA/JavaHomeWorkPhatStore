package com.example.javahomeworkphatstore.service;

import com.example.javahomeworkphatstore.model.entities.Brand;
import com.example.javahomeworkphatstore.model.entities.Category;
import com.example.javahomeworkphatstore.model.entities.Item;
import com.example.javahomeworkphatstore.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item getById(int id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Item item) {
        if (itemRepository.findById(item.getId()).isPresent()) {
            itemRepository.save(item);
        }
        return item;
    }

    public Item deleteById(int id) {
        Item item = itemRepository.findById(id);
        itemRepository.deleteById(id);
        return item;
    }

    public Item getByName(String name) {
        return itemRepository.findByModel(name).orElse(null);
    }

    public String getBrandByName(String name) {
        return itemRepository.findByModel(name).map(Item::getBrand)
                .map(Brand::getName).orElse(null);
    }

    public String getCategoryByName(String name) {
        return itemRepository.findByModel(name).map(Item::getCategory)
                .map(Category::getName).orElse(null);
    }

    public Item deleteByName(String name) {
        Optional<Item> item = itemRepository.findByModel(name);
        item.ifPresent(value -> itemRepository.delete(value));
        return item.orElse(null);
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
