package com.mobaled.inventory_service.sku;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mobaled.inventory_service.sku.dto.CreateSkuRequest;
import com.mobaled.inventory_service.sku.dto.SkuResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/skus")
public class SkuController {
    private final SkuService skuService;

    public SkuController(SkuService skuService){
        this.skuService = skuService;
    }

    @PostMapping
    public ResponseEntity<SkuResponse> create(@Valid @RequestBody CreateSkuRequest request){
        SkuResponse created = skuService.create(request);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.id())
            .toUri();
        
        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkuResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(skuService.getById(id));
    }
    
}
