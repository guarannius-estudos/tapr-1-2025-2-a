package com.example.sales.interfaces.rest;

import com.example.sales.application.item.RegisterItemSaleHandler;
import com.example.sales.domain.item.ItemSale;
import com.example.sales.interfaces.rest.dto.item.RegisterItemSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemSaleController {
    private final RegisterItemSaleHandler registerItemSaleHandler;

    @PostMapping
    public ResponseEntity<ItemSale> create(@RequestBody RegisterItemSaleRequest request) {
        return ResponseEntity.ok(registerItemSaleHandler.handle(request));
    }
}
