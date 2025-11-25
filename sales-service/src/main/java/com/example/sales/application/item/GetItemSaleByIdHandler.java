package com.example.sales.application.item;

import com.example.sales.domain.item.ItemSale;
import com.example.sales.domain.item.ItemSaleRepository;
import com.example.sales.interfaces.rest.dto.item.ItemSaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetItemSaleByIdHandler {
    private final ItemSaleRepository itemSaleRepository;

    public ItemSaleResponse handle(Long id) {
        ItemSale itemSale = itemSaleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda de item com o id " + id + " não encontrada."));

        return new ItemSaleResponse(
                itemSale.getId(),
                itemSale.getItemId(),
                itemSale.getItemName(),
                itemSale.getItemDescription(),
                itemSale.getItemBrand(),
                itemSale.getQuantity(),
                itemSale.getPrice()
        );
    }
}
