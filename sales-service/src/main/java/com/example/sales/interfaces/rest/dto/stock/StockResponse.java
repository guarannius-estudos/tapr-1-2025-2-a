package com.example.sales.interfaces.rest.dto.stock;

public record StockResponse(
        Long id,
        Long itemId,
        Integer quantity
) {

}
