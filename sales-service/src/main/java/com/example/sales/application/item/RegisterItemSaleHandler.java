package com.example.sales.application.item;

import com.example.sales.domain.item.InventoryClient;
import com.example.sales.domain.item.ItemSale;
import com.example.sales.domain.item.ItemSaleRepository;
import com.example.sales.interfaces.rest.dto.item.ItemInventoryResponse;
import com.example.sales.interfaces.rest.dto.item.RegisterItemSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterItemSaleHandler {
    private final ItemSaleRepository itemSaleRepository;
    private final InventoryClient inventoryClient;

    @Transactional
    public ItemSale handle(RegisterItemSaleRequest request) {
        ItemInventoryResponse inventoryItem = inventoryClient.getItemById(request.itemId());

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
