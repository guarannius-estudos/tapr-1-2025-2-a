package com.example.inventory.interfaces.rest.dto.stock;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterStockRequest(
        Long itemId,
        int quantity,
        LocalDateTime lastTransaction
) {

}
