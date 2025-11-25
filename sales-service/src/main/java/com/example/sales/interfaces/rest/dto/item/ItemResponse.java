package com.example.sales.interfaces.rest.dto.item;

public record ItemResponse(
        Long id,
        String name,
        String description,
        String category,
        String brand,
        Double price
) {

}
