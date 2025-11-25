package com.example.sales.application.service;

import com.example.sales.domain.service.ServiceSale;
import com.example.sales.domain.service.ServiceSaleRepository;
import com.example.sales.interfaces.rest.dto.service.RegisterServiceSaleRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterServiceSaleHandler {
    private final ServiceSaleRepository serviceSaleRepository;

    @Transactional
    public ServiceSale handle(RegisterServiceSaleRequest request) {
        ServiceSale serviceSale = new ServiceSale();
        serviceSale.setService(request.service());
        serviceSale.setPrice(request.price());

        return serviceSaleRepository.save(serviceSale);
    }
}
