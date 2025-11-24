package com.example.sales.interfaces.rest.dto.item;

public record RegisterItemSaleRequest(
        Long itemId,
        int quantity
) {

}
