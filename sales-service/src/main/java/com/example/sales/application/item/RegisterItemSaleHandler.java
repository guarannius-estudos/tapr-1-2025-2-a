package com.example.sales.application.item;

import com.example.sales.domain.stock.StockClient;
import com.example.sales.domain.item.ItemSale;
import com.example.sales.domain.item.ItemSaleRepository;
import com.example.sales.interfaces.rest.dto.item.ItemResponse;
import com.example.sales.interfaces.rest.dto.item.RegisterItemSaleRequest;
import com.example.sales.interfaces.rest.dto.stock.StockResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterItemSaleHandler {
    private final ItemSaleRepository itemSaleRepository;
    private final StockClient stockClient;

    @Transactional
    public ItemSale handle(RegisterItemSaleRequest request) {
        ItemResponse inventoryItem = stockClient.getItemById(request.itemId());
        StockResponse stockResponse = stockClient.getStockById(request.itemId());

        int newQuantity = stockResponse.quantity() - request.quantity();

        if (newQuantity < 0) {
            throw new RuntimeException(
                    "Estoque insuficiente para o item " + inventoryItem.id() + ". " +
                    "Estoque atual: " + stockResponse.quantity() + ". " +
                    "Quantidade solicitada: " + request.quantity()
            );
        }

        stockClient.updateStock(inventoryItem.id(), newQuantity);

        ItemSale itemSale = new ItemSale();
        itemSale.setItemId(inventoryItem.id());
        itemSale.setItemName(inventoryItem.name());
        itemSale.setItemDescription(inventoryItem.description());
        itemSale.setItemBrand(inventoryItem.brand());
        itemSale.setQuantity(request.quantity());
        itemSale.setPrice(inventoryItem.price() * request.quantity());

        return itemSaleRepository.save(itemSale);
    }
}
