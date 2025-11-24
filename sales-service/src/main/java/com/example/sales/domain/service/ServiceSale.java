package com.example.sales.domain.service;

import com.example.sales.domain.item.ItemSale;
import com.example.sales.domain.service.vo.Service;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "service_sale")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class ServiceSale {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Service service;

    @Column(nullable = false)
    private double price;
}
