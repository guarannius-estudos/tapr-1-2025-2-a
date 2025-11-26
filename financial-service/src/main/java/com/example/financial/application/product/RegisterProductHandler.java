package com.example.financial.application.product;

import com.example.financial.domain.product.Product;
import com.example.financial.domain.product.ProductRepository;
import com.example.financial.domain.sale.SaleClient;
import com.example.financial.interfaces.dto.product.ProductResponse;
import com.example.financial.interfaces.dto.product.RegisterProductRequest;
import com.example.financial.interfaces.dto.sale.ItemSaleResponse;
import com.example.financial.interfaces.dto.sale.ServiceSaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterProductHandler {
    private final ProductRepository productRepository;
    private final SaleClient saleClient;

    @Transactional
    public ProductResponse handle(RegisterProductRequest request) {
        Product product = new Product();
        product.setInvoice(request.invoiceId());
        product.setCategory(request.category());

        if (request.category().equals("ITEM")) {
            ItemSaleResponse itemSale = saleClient.getItemSaleById(request.saleId());
            product.setSaleId(itemSale.itemSaleID());
        } else if (request.category().equals("SERVICE")) {
            ServiceSaleResponse serviceSale = saleClient.getServiceSaleById(request.saleId());
            product.setSaleId(serviceSale.serviceSaleID());
        } else {
            throw new RuntimeException("Categoria não encontrada.");
        }

        productRepository.save(product);

        return new ProductResponse(
                product.getId(),
                product.getInvoice().getDocument(),
                product.getInvoice().getSerie(),
                product.getCategory().toString(),
                product.getSaleId()
        );
    }
}
