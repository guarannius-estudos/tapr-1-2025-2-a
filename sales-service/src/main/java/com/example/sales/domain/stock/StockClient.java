package com.example.sales.domain.stock;

import com.example.sales.interfaces.rest.dto.item.ItemResponse;
import com.example.sales.interfaces.rest.dto.stock.StockResponse;
import com.example.sales.interfaces.rest.dto.stock.UpdateStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class StockClient {
    private final RestTemplate restTemplate;

    private static final String INVENTORY_SERVICE_URL = "http://inventory-service:8080";

    public ItemResponse getItemById(Long itemId) {
        try {
            String url = INVENTORY_SERVICE_URL + "/items/" + itemId;
            return restTemplate.getForObject(url, ItemResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Item não encontrado no inventário: " + itemId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de inventário: " + e.getMessage(), e);
        }
    }

    public StockResponse getStockById(Long stockId) {
        try {
            String url = INVENTORY_SERVICE_URL + "/stock/" + stockId;
            return restTemplate.getForObject(url, StockResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Estoque não encontrado: " + stockId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de inventário: " + e.getMessage(), e);
        }
    }

    public StockResponse updateStock(Long stockId, int quantity) {
        try {
            String url = INVENTORY_SERVICE_URL + "/stock/" + stockId;
            UpdateStockRequest request = new UpdateStockRequest(quantity);
            HttpEntity<UpdateStockRequest> entity = new HttpEntity<>(request);
            return restTemplate.exchange(
                    url,
                    HttpMethod.PUT,
                    entity,
                    StockResponse.class
            ).getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Estoque não encontrado: " + stockId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de inventário: " + e.getMessage(), e);
        }
    }
}
