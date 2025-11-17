package com.example.inventory.infrastructure.stock;

import com.example.inventory.domain.stock.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockMovementJpaRepository extends JpaRepository<StockMovement, String> {
    List<StockMovement> findByItemId(String itemId);
}
