package com.example.javahomeworkphatstore.repository;

import com.example.javahomeworkphatstore.model.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByModel(String name);

    Item findById(int id);
}
