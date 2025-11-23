package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.ItemRepository;
import com.example.inventory.domain.item.vo.CategoryType;
import com.example.inventory.domain.stock.Stock;
import com.example.inventory.domain.stock.StockRepository;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterItemHandler {
    private final ItemRepository userRepository;
    private final StockRepository stockRepository;

    public ItemResponse handle(String name, String description, CategoryType category, String brand, double price) {
        Item item = new Item(name, description, category, brand, price);
        Item savedItem = userRepository.save(item);

        Stock stock = new Stock();
        stock.setItem(savedItem);
        stock.setQuantity(0);
        stock.setLastTransaction(LocalDateTime.now());
        stockRepository.save(stock);

        return new ItemResponse(
                savedItem.getId(),
                savedItem.getName(),
                savedItem.getDescription(),
                savedItem.getCategory().toString(),
                savedItem.getBrand(),
                savedItem.getPrice()
        );
    }
}
