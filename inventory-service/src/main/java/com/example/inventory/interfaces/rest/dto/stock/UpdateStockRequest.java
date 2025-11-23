package com.example.inventory.interfaces.rest.dto.stock;

public record UpdateStockRequest(
        Long id,
        int quantity
) {

}
