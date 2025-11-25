package com.example.sales.interfaces.rest;

import com.example.sales.application.service.RegisterServiceSaleHandler;
import com.example.sales.domain.service.ServiceSale;
import com.example.sales.interfaces.rest.dto.service.RegisterServiceSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceSaleController {
    private final RegisterServiceSaleHandler registerServiceSaleHandler;

    @PostMapping
    public ResponseEntity<ServiceSale> create(@RequestBody RegisterServiceSaleRequest request) {
        return ResponseEntity.ok(registerServiceSaleHandler.handle(request));
    }
}
