package com.example.financial.interfaces.dto.invoice;

public record InvoiceResponse(
        Long id,
        int document,
        String serie,
        double totalValue
) {

}
