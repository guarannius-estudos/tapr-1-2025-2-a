package com.example.financial.interfaces.dto.product;

import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.product.vo.Category;

public record RegisterProductRequest(
        Invoice invoiceId,
        Category category,
        Long saleId
) {

}
