package com.example.financial.domain.invoice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "invoice")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int document;

    @Column(nullable = false)
    private String serie;

    @Column(nullable = false)
    private double productsValue;

    @Column(nullable = false)
    private double totalValue;
}
