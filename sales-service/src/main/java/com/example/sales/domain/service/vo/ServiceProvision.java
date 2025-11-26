package com.example.sales.domain.service.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Getter
public class ServiceProvision {
    @Enumerated(EnumType.STRING)
    @Column(name = "service", nullable = false, length = 20)
    private ServiceType value;

    private ServiceProvision(ServiceType value) {
        if (value == null) {
            throw new IllegalArgumentException("Serviço obrigatório.");
        }

        this.value = value;
    }

    public static ServiceProvision of(ServiceType value) {
        return new ServiceProvision(value);
    }
}
