package com.example.inventory.interfaces.rest;

import com.example.inventory.application.item.ListItensHandler;
import com.example.inventory.application.item.RegisterItemHandler;
import com.example.inventory.interfaces.rest.dto.item.ItemResponse;
import com.example.inventory.interfaces.rest.dto.item.RegisterItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/itens")
@RequiredArgsConstructor
public class ItemController {
    private final ListItensHandler listItensHandler;
    private final RegisterItemHandler registerItemHandler;

    @GetMapping
    public ResponseEntity<Page<ItemResponse>> list(Pageable pageable) {
        Page<ItemResponse> page = listItensHandler.handle(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<ItemResponse> register(@RequestBody RegisterItemRequest request) {
        ItemResponse created = registerItemHandler.handle(request.name(), request.description(), request.category(), request.brand(), request.price());
        return ResponseEntity.created(URI.create("/itens/" + created.id())).body(created);
    }
}
