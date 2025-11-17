package com.example.inventory.interfaces.rest.dto.item;

public record CreateItemRequest (
        String name,
        String description,
        int quantity
) {

}
