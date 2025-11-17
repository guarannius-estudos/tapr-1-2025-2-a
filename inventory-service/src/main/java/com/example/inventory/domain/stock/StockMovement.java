package com.example.inventory.domain.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "stock_movement")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class StockMovement {

    @Id
    @Column(length = 36)
    private String id;

    @Column(name = "item_id", nullable = false, length = 36)
    private String itemId;

    @Column(nullable = false)
    private int amount;

    @Column(name = "new_quantity", nullable = false)
    private int newQuantity;

    @Column(nullable = false)
    private String type;

    @Column
    private String reason;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public StockMovement(String id, String itemId, int amount, int newQuantity, String type, String reason, LocalDateTime createdAt) {
        this.id = id;
        this.itemId = itemId;
        this.amount = amount;
        this.newQuantity = newQuantity;
        this.type = type;
        this.reason = reason;
        this.createdAt = createdAt;
    }
}
