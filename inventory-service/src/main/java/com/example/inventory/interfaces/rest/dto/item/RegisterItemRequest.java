package com.example.inventory.interfaces.rest.dto.item;

import com.example.inventory.domain.item.vo.CategoryType;

public record RegisterItemRequest(
        String name,
        String description,
        CategoryType category,
        String brand,
        double price
) {

}
