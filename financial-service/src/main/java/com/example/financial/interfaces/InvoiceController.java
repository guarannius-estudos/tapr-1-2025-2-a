package com.example.financial.interfaces;

import com.example.financial.application.invoice.GetInvoiceByIdHandler;
import com.example.financial.application.invoice.RegisterInvoiceHandler;
import com.example.financial.interfaces.dto.invoice.InvoiceResponse;
import com.example.financial.interfaces.dto.invoice.RegisterInvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {
    private final GetInvoiceByIdHandler getInvoiceByIdHandler;
    private final RegisterInvoiceHandler registerInvoiceHandler;

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getById(@PathVariable Long id) {
        InvoiceResponse invoice = getInvoiceByIdHandler.handle(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponse> register(@RequestBody RegisterInvoiceRequest request) {
        InvoiceResponse created = registerInvoiceHandler.handle(request);
        return ResponseEntity.created(URI.create("/invoice/" + created.id())).body(created);
    }
}
