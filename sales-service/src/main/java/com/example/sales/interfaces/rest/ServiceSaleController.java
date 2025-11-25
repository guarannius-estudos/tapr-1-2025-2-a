package com.example.sales.interfaces.rest;

import com.example.sales.application.service.GetServiceSaleByIdHandler;
import com.example.sales.application.service.RegisterServiceSaleHandler;
import com.example.sales.domain.service.ServiceSale;
import com.example.sales.interfaces.rest.dto.service.RegisterServiceSaleRequest;
import com.example.sales.interfaces.rest.dto.service.ServiceSaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class ServiceSaleController {
    private final GetServiceSaleByIdHandler getServiceSaleByIdHandler;
    private final RegisterServiceSaleHandler registerServiceSaleHandler;

    @PostMapping
    public ResponseEntity<ServiceSale> create(@RequestBody RegisterServiceSaleRequest request) {
        return ResponseEntity.ok(registerServiceSaleHandler.handle(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceSaleResponse> getById(@PathVariable Long id) {
        ServiceSaleResponse serviceSale = getServiceSaleByIdHandler.handle(id);
        return ResponseEntity.ok(serviceSale);
    }
}
