package com.example.sales.domain.item;

import com.example.sales.interfaces.rest.dto.item.ItemInventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class InventoryClient {
    private final RestTemplate restTemplate;

    private static final String INVENTORY_SERVICE_URL = "http://inventory-service:8080";

    public ItemInventoryResponse getItemById(Long itemId) {
        try {
            String url = INVENTORY_SERVICE_URL + "/items/" + itemId;
            return restTemplate.getForObject(url, ItemInventoryResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Item não encontrado no inventário: " + itemId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de inventário: " + e.getMessage(), e);
        }
    }
}
