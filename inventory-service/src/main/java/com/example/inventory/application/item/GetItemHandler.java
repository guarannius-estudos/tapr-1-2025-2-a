package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.item.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class GetItemHandler {

    private final ItemRepository repository;

    public GetItemHandler(ItemRepository repository) {
        this.repository = repository;
    }

    public Item handle(String id) {
        return repository.findById(new ItemId(id))
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));
    }
}
