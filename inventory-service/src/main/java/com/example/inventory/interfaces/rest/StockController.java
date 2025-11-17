package com.example.inventory.interfaces.rest;

import com.example.inventory.application.item.AdjustStockHandler;
import com.example.inventory.application.item.GetItemHandler;
import com.example.inventory.interfaces.rest.dto.item.AdjustStockRequest;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final AdjustStockHandler adjustStockHandler;
    private final GetItemHandler getItemHandler;

    public StockController(
            AdjustStockHandler adjustStockHandler,
            GetItemHandler getItemHandler
    ) {
        this.adjustStockHandler = adjustStockHandler;
        this.getItemHandler = getItemHandler;
    }

    @PostMapping("/{id}/increase")
    public ItemResponse increaseStock(
            @PathVariable String id,
            @RequestBody AdjustStockRequest request
    ) {
        var updatedItem = adjustStockHandler.handle(id, request.amount());
        return new ItemResponse(updatedItem);
    }

    @PostMapping("/{id}/decrease")
    public ItemResponse decreaseStock(
            @PathVariable String id,
            @RequestBody AdjustStockRequest request
    ) {
        var updatedItem = adjustStockHandler.handle(id, -Math.abs(request.amount()));
        return new ItemResponse(updatedItem);
    }

    @GetMapping("/{id}")
    public ItemResponse getStock(@PathVariable String id) {
        var item = getItemHandler.handle(id);
        return new ItemResponse(item);
    }
}
