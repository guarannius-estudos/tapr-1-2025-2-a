package com.example.inventory.domain.item.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class Category {
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private CategoryType value;

    private Category(CategoryType value) {
        if (value == null) {
            throw new IllegalArgumentException("Categoria obrigatória.");
        }

        this.value = value;
    }

    public static Category of(CategoryType value) {
        return new Category(value);
    }
}
