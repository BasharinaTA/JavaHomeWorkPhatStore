package com.example.javahomeworkphatstore.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "brand", cascade=CascadeType.ALL)
    private Set<Item> items;

    public Brand(String name) {
        this.name = name;
        items = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items
                .stream()
                .map(Item::getId)
                .collect(Collectors.toSet()) +
                '}';
    }
}
