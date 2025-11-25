package com.example.inventory.application.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.ItemRepository;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemByIdHandler {
    private final ItemRepository itemRepository;

    public ItemResponse handle(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item não encontrado com ID: " + id));

        return new ItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getCategory().toString(),
                item.getBrand(),
                item.getPrice()
        );
    }
}