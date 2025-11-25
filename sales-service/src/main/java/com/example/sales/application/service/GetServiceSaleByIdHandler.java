package com.example.sales.application.service;

import com.example.sales.domain.service.ServiceSale;
import com.example.sales.domain.service.ServiceSaleRepository;
import com.example.sales.interfaces.rest.dto.service.ServiceSaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetServiceSaleByIdHandler {
    private final ServiceSaleRepository serviceSaleRepository;

    public ServiceSaleResponse handle(Long id) {
        ServiceSale serviceSale = serviceSaleRepository.findById(id).orElseThrow(() -> new RuntimeException("Venda de serviço com o id " + id + " não encontrada."));

        return new ServiceSaleResponse(
                serviceSale.getId(),
                serviceSale.getService().toString(),
                serviceSale.getPrice()
        );
    }
}
