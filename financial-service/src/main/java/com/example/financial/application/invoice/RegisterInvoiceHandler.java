package com.example.financial.application.invoice;

import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.invoice.InvoiceRepository;
import com.example.financial.interfaces.dto.invoice.InvoiceResponse;
import com.example.financial.interfaces.dto.invoice.RegisterInvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterInvoiceHandler {
    private final InvoiceRepository invoiceRepository;

    @Transactional
    public InvoiceResponse handle(RegisterInvoiceRequest request) {
        Invoice invoice = new Invoice();
        invoice.setDocument(request.document());
        invoice.setSerie(request.serie());
        invoice.setProductsValue(0);
        invoice.setTotalValue(0);

        invoiceRepository.save(invoice);

        return new InvoiceResponse(
                invoice.getId(),
                invoice.getDocument(),
                invoice.getSerie(),
                invoice.getProductsValue(),
                invoice.getTotalValue()
        );
    }
}
