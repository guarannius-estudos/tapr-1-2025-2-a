package com.example.inventory.interfaces.rest.dto.item;

import com.example.inventory.domain.item.Item;

public record ItemResponse(
        String id,
        String name,
        String description,
        int quantity
) {
    public ItemResponse(Item item) {
        this(item.getId().idValue(), item.getName(), item.getDescription(), item.getQuantity());
    }
}
