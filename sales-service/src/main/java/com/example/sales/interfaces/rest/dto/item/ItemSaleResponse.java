package com.example.sales.interfaces.rest.dto.item;

public record ItemSaleResponse(
        Long id,
        Long itemId,
        String itemName,
        String itemDescription,
        String itemBrand,
        int quantity,
        double price
) {

}
