package com.example.financial.application.product;

import com.example.financial.domain.product.Product;
import com.example.financial.domain.product.ProductRepository;
import com.example.financial.interfaces.dto.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListProductsHandler {
    private final ProductRepository productRepository;

    public Page<ProductResponse> handle(Long id, Pageable pageable) {
        Page<Product> page = productRepository.findByInvoiceId(id, pageable);

        return page.map(product -> new ProductResponse(
                product.getId(),
                product.getInvoice().getDocument(),
                product.getInvoice().getSerie(),
                product.getCategory().getValue().toString(),
                product.getSaleId()
        ));
    }
}
