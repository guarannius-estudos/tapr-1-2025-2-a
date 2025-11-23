package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.ItemRepository;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListItensHandler {
    private final ItemRepository itemRepository;

    public ListItensHandler(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<ItemResponse> handle(Pageable pageable) {
        Page<Item> page = itemRepository.findAll(pageable);

        return page.map(item -> new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getCategory().toString(),
                item.getBrand(),
                item.getPrice()
        ));
    }
}
