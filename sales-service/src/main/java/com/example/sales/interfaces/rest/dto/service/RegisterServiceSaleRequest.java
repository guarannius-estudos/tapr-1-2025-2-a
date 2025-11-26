package com.example.sales.interfaces.rest.dto.service;

import com.example.sales.domain.service.vo.ServiceType;

public record RegisterServiceSaleRequest(
    ServiceType service,
    Double price
) {

}
