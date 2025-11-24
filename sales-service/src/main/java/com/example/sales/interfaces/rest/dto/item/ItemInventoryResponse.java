package com.example.sales.interfaces.rest.dto.item;

public record ItemInventoryResponse(
        Long id,
        String name,
        String description,
        String category,
        String brand,
        Double price
) {

}
