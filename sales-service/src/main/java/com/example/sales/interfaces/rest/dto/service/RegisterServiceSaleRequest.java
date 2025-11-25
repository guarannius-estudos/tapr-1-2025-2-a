package com.example.sales.interfaces.rest.dto.service;

import com.example.sales.domain.service.vo.Service;

public record RegisterServiceSaleRequest(
    Service service,
    Double price
) {

}
