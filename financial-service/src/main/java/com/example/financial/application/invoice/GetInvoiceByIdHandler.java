package com.example.financial.application.invoice;

import com.example.financial.domain.invoice.Invoice;
import com.example.financial.domain.invoice.InvoiceRepository;
import com.example.financial.interfaces.dto.invoice.InvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetInvoiceByIdHandler {
    private final InvoiceRepository invoiceRepository;

    public InvoiceResponse handle(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Nota com o id " + id + " não encontrada."));

        return new InvoiceResponse(
                invoice.getId(),
                invoice.getDocument(),
                invoice.getSerie(),
                invoice.getTotalValue()
        );
    }
}
