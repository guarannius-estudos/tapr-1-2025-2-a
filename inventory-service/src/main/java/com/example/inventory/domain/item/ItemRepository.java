package com.example.inventory.domain.item;

import com.example.inventory.domain.item.vo.ItemId;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(ItemId id);
    List<Item> findAll();
}
