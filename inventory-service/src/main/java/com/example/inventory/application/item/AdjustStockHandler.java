package com.example.inventory.application.item;

import com.example.inventory.application.stock.RegisterStockMovementHandler;
import com.example.inventory.domain.item.*;
import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.stock.vo.StockMovementType;
import org.springframework.stereotype.Service;

@Service
public class AdjustStockHandler {

    private final ItemRepository itemRepository;
    private final RegisterStockMovementHandler movementHandler;

    public AdjustStockHandler(ItemRepository itemRepository,
                              RegisterStockMovementHandler movementHandler) {
        this.itemRepository = itemRepository;
        this.movementHandler = movementHandler;
    }

    public Item handle(String id, int amount) {

        Item item = itemRepository.findById(new ItemId(id))
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));

        item.adjustStock(amount);

        itemRepository.save(item);

        movementHandler.register(
                item,
                amount,
                amount >= 0 ? StockMovementType.INCREASE : StockMovementType.DECREASE,
                "Stock adjusted"
        );

        return item;
    }
}
