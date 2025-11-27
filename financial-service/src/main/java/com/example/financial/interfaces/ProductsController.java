package com.example.financial.interfaces;

import com.example.financial.application.product.ListProductsHandler;
import com.example.financial.application.product.RegisterProductHandler;
import com.example.financial.interfaces.dto.product.ProductResponse;
import com.example.financial.interfaces.dto.product.RegisterProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/invoice/product")
@RequiredArgsConstructor
public class ProductsController {
    private final ListProductsHandler listProductsHandler;
    private final RegisterProductHandler registerProductHandler;

    @GetMapping("/{id}")
    public ResponseEntity<Page<ProductResponse>> listByInvoice(
            @PathVariable Long id,
            Pageable pageable
    ) {
        Page<ProductResponse> products = listProductsHandler.handle(id, pageable);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> register(@RequestBody RegisterProductRequest request) {
        ProductResponse created = registerProductHandler.handle(request);
        return ResponseEntity.created(URI.create("/invoice/" + created.id())).body(created);
    }
}
