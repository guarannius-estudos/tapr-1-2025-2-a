package com.example.inventory.interfaces.rest;

import com.example.inventory.application.stock.GetStockByIdHandler;
import com.example.inventory.application.stock.ListStockHandler;
import com.example.inventory.application.stock.UpdateStockHandler;
import com.example.inventory.interfaces.rest.dto.stock.StockResponse;
import com.example.inventory.interfaces.rest.dto.stock.UpdateStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final GetStockByIdHandler getStockByIdHandler;
    private final ListStockHandler listStockHandler;
    private final UpdateStockHandler updateStockHandler;

    @GetMapping
    public ResponseEntity<Page<StockResponse>> list(Pageable pageable) {
        Page<StockResponse> page = listStockHandler.handle(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponse> getById(@PathVariable("id") Long id) {
        StockResponse stock = getStockByIdHandler.handle(id);
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockResponse> update(@PathVariable("id") Long id, @RequestBody UpdateStockRequest request) {
        StockResponse updated = updateStockHandler.handle(id, request.quantity());
        return ResponseEntity.ok(updated);
    }
}
