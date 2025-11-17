package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListItemsHandler {

    private final ItemRepository repository;

    public ListItemsHandler(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> handle() {
        return repository.findAll();
    }
}
