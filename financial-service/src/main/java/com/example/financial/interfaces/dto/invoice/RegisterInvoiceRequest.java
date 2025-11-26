package com.example.financial.interfaces.dto.invoice;

import jakarta.persistence.Column;

public record RegisterInvoiceRequest(
        int document,
        String serie
) {

}
