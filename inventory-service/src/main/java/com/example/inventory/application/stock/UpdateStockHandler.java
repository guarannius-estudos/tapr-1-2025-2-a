package com.example.inventory.application.stock;

import com.example.inventory.domain.stock.Stock;
import com.example.inventory.domain.stock.StockRepository;
import com.example.inventory.interfaces.rest.dto.stock.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UpdateStockHandler {
    private final StockRepository stockRepository;

    public StockResponse handle(Long id, int quantity) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Estoque com o id " + id + " não encontrado."));
        stock.setQuantity(quantity);
        stock.setLastTransaction(LocalDateTime.now());
        Stock updatedStock = stockRepository.save(stock);

        return new StockResponse(
                updatedStock.getId(),
                updatedStock.getItem().getName(),
                updatedStock.getItem().getDescription(),
                updatedStock.getItem().getBrand(),
                updatedStock.getQuantity(),
                updatedStock.getLastTransaction()
        );
    }
}
