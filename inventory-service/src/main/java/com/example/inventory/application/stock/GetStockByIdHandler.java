package com.example.inventory.application.stock;

import com.example.inventory.domain.item.Item;
import com.example.inventory.domain.item.ItemRepository;
import com.example.inventory.domain.item.vo.ItemNotFoundException;
import com.example.inventory.domain.stock.Stock;
import com.example.inventory.domain.stock.StockRepository;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import com.example.inventory.interfaces.rest.dto.stock.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStockByIdHandler {
    private final StockRepository stockRepository;

    public StockResponse handle(Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Estoque não encontrado com ID: " + id));

        return new StockResponse(
                stock.getId(),
                stock.getItem().getName(),
                stock.getItem().getDescription(),
                stock.getItem().getBrand(),
                stock.getQuantity(),
                stock.getLastTransaction()
        );
    }
}
