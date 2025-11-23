package com.example.inventory.interfaces.rest;

import com.example.inventory.application.stock.ListStockHandler;
import com.example.inventory.interfaces.rest.dto.stock.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final ListStockHandler listStockHandler;

    @GetMapping
    public ResponseEntity<Page<StockResponse>> list(Pageable pageable) {
        Page<StockResponse> page = listStockHandler.handle(pageable);
        return ResponseEntity.ok(page);
    }
}
