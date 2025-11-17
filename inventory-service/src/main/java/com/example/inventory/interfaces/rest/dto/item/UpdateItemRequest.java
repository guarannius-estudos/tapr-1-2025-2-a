package com.example.inventory.interfaces.rest.dto.item;

public record UpdateItemRequest(
        String name,
        String description
) {

}
