package com.example.inventory.infrastructure.stock;

import com.example.inventory.domain.item.vo.ItemId;
import com.example.inventory.domain.stock.StockMovement;
import com.example.inventory.domain.stock.StockMovementRepository;
import com.example.inventory.domain.stock.vo.StockMovementType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StockMovementRepositoryImpl implements StockMovementRepository {

    private final StockMovementJpaRepository jpa;

    public StockMovementRepositoryImpl(StockMovementJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void save(StockMovement movement) {
        var entity = new StockMovement(
                movement.getId(),
                movement.getItemId(),
                movement.getAmount(),
                movement.getNewQuantity(),
                movement.getType(),
                movement.getReason(),
                movement.getCreatedAt()
        );

        jpa.save(entity);
    }

    @Override
    public List<StockMovement> findByItemId(ItemId id) {
        return jpa.findByItemId(id.idValue()).stream().map(e ->
                new StockMovement(
                        e.getId(),
                        e.getItemId(),
                        e.getAmount(),
                        e.getNewQuantity(),
                        StockMovementType.valueOf(e.getType()).toString(),
                        e.getReason(),
                        e.getCreatedAt()
                )
        ).collect(Collectors.toList());
    }
}
