package com.example.inventory.interfaces.rest.dto.stock;

import com.example.inventory.domain.stock.StockMovement;

import java.time.LocalDateTime;

public record StockMovementResponse(
        String id,
        String itemId,
        int amount,
        int newQuantity,
        String type,
        String reason,
        LocalDateTime createdAt
) {
    public StockMovementResponse(StockMovement m) {
        this(
                m.getId(),
                m.getItemId(),
                m.getAmount(),
                m.getNewQuantity(),
                m.getType(),
                m.getReason(),
                m.getCreatedAt()
        );
    }
}
