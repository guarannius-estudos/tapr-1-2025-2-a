package com.example.inventory.interfaces.rest.dto.stock;

import java.time.LocalDateTime;

public record StockResponse(
        Long id,
        String itemName,
        String itemDescription,
        String itemBrand,
        int quantity,
        LocalDateTime lastTransaction
) {

}
