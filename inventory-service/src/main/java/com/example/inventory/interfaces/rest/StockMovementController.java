package com.example.inventory.interfaces.rest;

import com.example.inventory.application.item.GetItemHandler;
import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.stock.StockMovementRepository;
import com.example.inventory.interfaces.rest.dto.stock.StockMovementResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock/movements")
public class StockMovementController {

    private final StockMovementRepository repository;

    public StockMovementController(StockMovementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{itemId}")
    public List<StockMovementResponse> list(@PathVariable String itemId) {
        return repository
                .findByItemId(new ItemId(itemId))
                .stream()
                .map(StockMovementResponse::new)
                .toList();
    }
}
