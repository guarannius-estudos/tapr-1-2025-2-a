package com.example.inventory.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.inventory.application.item.*;
import com.example.inventory.interfaces.rest.dto.item.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final CreateItemHandler createHandler;
    private final ListItemsHandler listHandler;
    private final UpdateItemHandler updateHandler;
    private final AdjustStockHandler adjustStockHandler;

    public ItemController(
            CreateItemHandler createHandler,
            ListItemsHandler listHandler,
            UpdateItemHandler updateHandler,
            AdjustStockHandler adjustStockHandler) {
        this.createHandler = createHandler;
        this.listHandler = listHandler;
        this.updateHandler = updateHandler;
        this.adjustStockHandler = adjustStockHandler;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> create(@RequestBody CreateItemRequest request) {
        var item = createHandler.handle(request.name(), request.description(), request.quantity());
        var response = new ItemResponse(item);
        return ResponseEntity.created(URI.create("/items/" + item.getId().idValue())).body(response);
    }

    @GetMapping
    public List<ItemResponse> list() {
        return listHandler.handle().stream().map(ItemResponse::new).toList();
    }

    @PutMapping("/{id}")
    public ItemResponse update(@PathVariable String id, @RequestBody UpdateItemRequest request) {
        var item = updateHandler.handle(id, request.name(), request.description());
        return new ItemResponse(item);
    }

    @PostMapping("/{id}/adjust-stock")
    public ItemResponse adjustStock(@PathVariable String id, @RequestBody AdjustStockRequest request) {
        var item = adjustStockHandler.handle(id, request.amount());
        return new ItemResponse(item);
    }
}
