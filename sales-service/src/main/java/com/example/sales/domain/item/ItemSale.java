package com.example.sales.domain.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item_sale")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class ItemSale {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String itemDescription;

    @Column(nullable = false)
    private String itemBrand;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;
}
