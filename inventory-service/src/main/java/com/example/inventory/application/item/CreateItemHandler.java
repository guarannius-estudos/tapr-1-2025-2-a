package com.example.inventory.application.item;

import com.example.inventory.domain.item.*;
import com.example.inventory.domain.item.vo.ItemId;
import org.springframework.stereotype.Service;

@Service
public class CreateItemHandler {

    private final ItemRepository repository;

    public CreateItemHandler(ItemRepository repository) {
        this.repository = repository;
    }

    public Item handle(String name, String description, int quantity) {
        Item item = new Item(new ItemId(), name, description, quantity);
        return repository.save(item);
    }
}
