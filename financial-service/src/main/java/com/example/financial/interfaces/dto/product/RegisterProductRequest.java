package com.example.financial.interfaces.dto.product;

import com.example.financial.domain.product.vo.CategoryType;

public record RegisterProductRequest(
        Long invoiceId,
        CategoryType category,
        Long saleId
) {

}
