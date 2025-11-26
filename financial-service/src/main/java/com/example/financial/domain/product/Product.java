package com.example.financial.domain.product;

import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.product.vo.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "invoice_product")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Invoice invoice;

    @Embedded
    private Category category;

    private Long saleId;
}
