package com.example.inventory.infrastructure.item;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.item.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemJpaRepository jpa;

    public ItemRepositoryImpl(ItemJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Item save(Item item) {
        Item entity = toEntity(item);
        Item saved = jpa.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Item> findById(ItemId id) {
        return jpa.findById(id.idValue()).map(this::toDomain);
    }

    @Override
    public List<Item> findAll() {
        return jpa.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    private Item toEntity(Item item) {
        return new Item(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getQuantity()
        );
    }

    private Item toDomain(Item e) {
        return new Item(new ItemId(e.getId().toString()), e.getName(), e.getDescription(), e.getQuantity());
    }
}
