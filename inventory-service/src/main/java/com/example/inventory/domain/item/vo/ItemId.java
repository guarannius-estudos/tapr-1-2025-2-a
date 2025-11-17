package com.example.inventory.domain.item.vo;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ItemId {
    private final String idValue;

    public ItemId() {
        this(UUID.randomUUID().toString());
    }

    public ItemId(String idValue) {
        this.idValue = Objects.requireNonNull(idValue);
    }

    public String idValue() {
        return idValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemId itemId = (ItemId) o;
        return idValue.equals(itemId.idValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValue);
    }

    @Override
    public String toString() {
        return idValue;
    }
}
