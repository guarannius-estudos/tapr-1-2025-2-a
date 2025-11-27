package com.example.financial.application.invoice;

import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.invoice.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateInvoiceHandler {
    private final InvoiceRepository invoiceRepository;

    public void handle(Long id, double totalValue) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota com o id " + id + " não encontrada."));
        invoice.setTotalValue(totalValue);
        invoiceRepository.save(invoice);
    }
}
