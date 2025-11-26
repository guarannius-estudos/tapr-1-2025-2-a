package com.example.financial.interfaces;

import com.example.financial.application.product.RegisterProductHandler;
import com.example.financial.interfaces.dto.product.ProductResponse;
import com.example.financial.interfaces.dto.product.RegisterProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/invoice/product")
@RequiredArgsConstructor
public class ProductsController {
    private final RegisterProductHandler registerProductHandler;

    @PostMapping
    public ResponseEntity<ProductResponse> register(@RequestBody RegisterProductRequest request) {
        ProductResponse created = registerProductHandler.handle(request);
        return ResponseEntity.created(URI.create("/invoice/" + created.id())).body(created);
    }
}
