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
public class Service {
    @Enumerated(EnumType.STRING)
    @Column(name = "service", nullable = false, length = 20)
    private ServiceType value;

    private Service(ServiceType value) {
        if (value == null) {
            throw new IllegalArgumentException("Serviço obrigatório.");
        }

        this.value = value;
    }

    public static Service of(ServiceType value) {
        return new Service(value);
    }
}
