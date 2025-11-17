package com.example.inventory.domain.stock;

import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.stock.StockMovement;

import java.util.List;

public interface StockMovementRepository {
    void save(StockMovement movement);
    List<StockMovement> findByItemId(ItemId id);
}
