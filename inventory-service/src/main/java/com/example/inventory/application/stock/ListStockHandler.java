package com.example.inventory.application.stock;

import com.example.inventory.domain.stock.Stock;
import com.example.inventory.domain.stock.StockRepository;
import com.example.inventory.interfaces.rest.dto.stock.StockResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListStockHandler {
    private final StockRepository stockRepository;

    public ListStockHandler(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Page<StockResponse> handle(Pageable pageable) {
        Page<Stock> page = stockRepository.findAll(pageable);

        return page.map(stock -> new StockResponse(
                stock.getId(),
                stock.getItem().getName(),
                stock.getItem().getDescription(),
                stock.getItem().getBrand(),
                stock.getQuantity(),
                stock.getLastTransaction()
        ));
    }
}
