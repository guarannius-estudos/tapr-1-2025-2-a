package com.example.inventory.domain.item;

import com.example.inventory.domain.item.vo.Category;
import com.example.inventory.domain.item.vo.CategoryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Embedded
    private Category category;

    private String brand;

    private double price;

    public Item(String name, String description, CategoryType category, String brand, double price) {
        this.name = name;
        this.description = description;
        this.category = Category.of(category);
        this.brand = brand;
        this.price = price;
    }
}
