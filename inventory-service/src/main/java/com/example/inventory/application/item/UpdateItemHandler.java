package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.item.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateItemHandler {

    private final ItemRepository repository;

    public UpdateItemHandler(ItemRepository repository) {
        this.repository = repository;
    }

    public Item handle(String id, String name, String description) {
        Item item = repository.findById(new ItemId(id))
                .orElseThrow(() -> new RuntimeException("Item not found: " + id));

        // mutate domain object (you may prefer immutability and create new object)
        item.setName(name);
        item.setDescription(description);

        return repository.save(item);
    }
}
