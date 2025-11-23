package com.example.inventory.interfaces.rest.dto.item;

import java.util.UUID;

public record ItemResponse(
        Long id,
        String name,
        String description,
        String category,
        String brand,
        double price
) {

}
