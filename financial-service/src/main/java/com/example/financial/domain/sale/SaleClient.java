package com.example.financial.domain.sale;

import com.example.financial.interfaces.dto.sale.ItemSaleResponse;
import com.example.financial.interfaces.dto.sale.ServiceSaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class SaleClient {
    private final RestTemplate restTemplate;

    private static final String SALES_SERVICE_URL = "http://sales-service:8080";

    public ItemSaleResponse getItemSaleById(Long itemId) {
        try {
            String url = SALES_SERVICE_URL + "/items/" + itemId;
            return restTemplate.getForObject(url, ItemSaleResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Venda de item não encontrada: " + itemId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de vendas: " + e.getMessage(), e);
        }
    }

    public ServiceSaleResponse getServiceSaleById(Long serviceId) {
        try {
            String url = SALES_SERVICE_URL + "/services/" + serviceId;
            return restTemplate.getForObject(url, ServiceSaleResponse.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Venda de serviço não encontrada: " + serviceId + ".");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comunicar com o serviço de vendas: " + e.getMessage(), e);
        }
    }
}
