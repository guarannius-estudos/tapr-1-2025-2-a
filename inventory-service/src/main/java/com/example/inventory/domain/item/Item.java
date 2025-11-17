package com.example.inventory.domain.item;

import com.example.inventory.domain.item.vo.ItemId;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private ItemId id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private int quantity = 0;

    public Item(ItemId id, String name, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public void adjustStock(int amount) {
        this.quantity += amount;
    }
}
