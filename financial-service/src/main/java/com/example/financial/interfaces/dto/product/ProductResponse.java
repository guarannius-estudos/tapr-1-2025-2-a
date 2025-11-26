package com.example.financial.interfaces.dto.product;

public record ProductResponse(
        Long id,
        int document,
        String serie,
        String category,
        Long saleId
) {

}
