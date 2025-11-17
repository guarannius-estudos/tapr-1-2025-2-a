package com.example.inventory.application.stock;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.stock.StockMovement;
import com.example.inventory.domain.stock.StockMovementRepository;
import com.example.inventory.domain.stock.vo.StockMovementType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegisterStockMovementHandler {
    private final StockMovementRepository repository;

    public RegisterStockMovementHandler(StockMovementRepository repository) {
        this.repository = repository;
    }

    public void register(Item item, int amount, StockMovementType type, String reason) {
        StockMovement movement = new StockMovement(
                UUID.randomUUID().toString(),
                item.getId().toString(),
                amount,
                item.getQuantity(),
                type.toString(),
                reason,
                LocalDateTime.now()
        );

        repository.save(movement);
    }
}
