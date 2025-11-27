package com.example.financial.application.product;

import com.example.financial.application.invoice.UpdateInvoiceHandler;
import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.invoice.InvoiceRepository;
import com.example.financial.domain.product.Product;
import com.example.financial.domain.product.ProductRepository;
import com.example.financial.domain.product.vo.Category;
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
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final SaleClient saleClient;
    private final UpdateInvoiceHandler updateInvoiceHandler;

    @Transactional
    public ProductResponse handle(RegisterProductRequest request) {
        Invoice invoice = invoiceRepository.findById(request.invoiceId()).orElseThrow(() -> new RuntimeException("Nota não encontrada: " + request.invoiceId()));

        Product product = new Product();
        product.setInvoice(invoice);
        product.setCategory(Category.of(request.category()));

        switch (request.category()) {
            case ITEM -> {
                ItemSaleResponse itemSale = saleClient.getItemSaleById(request.saleId());
                product.setSaleId(itemSale.id());
                invoice.setTotalValue(invoice.getTotalValue() + itemSale.price());
            }
            case SERVICE -> {
                ServiceSaleResponse serviceSale = saleClient.getServiceSaleById(request.saleId());
                product.setSaleId(serviceSale.id());
                invoice.setTotalValue(invoice.getTotalValue() + serviceSale.price());
            }
        }

        productRepository.save(product);
        updateInvoiceHandler.handle(invoice.getId(), invoice.getTotalValue());

        return new ProductResponse(
                product.getId(),
                product.getInvoice().getDocument(),
                product.getInvoice().getSerie(),
                product.getCategory().getValue().toString(),
                product.getSaleId()
        );
    }
}
