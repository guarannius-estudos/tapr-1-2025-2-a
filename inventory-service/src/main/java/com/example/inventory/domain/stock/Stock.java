package com.example.inventory.domain.stock;

import com.example.inventory.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "stock")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Stock {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(nullable = false)
    private int quantity;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime lastTransaction;
}
