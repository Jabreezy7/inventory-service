package com.mobaled.inventory_service.sku.dto;

import java.time.OffsetDateTime;

import com.mobaled.inventory_service.sku.Sku;

public record SkuResponse(
    Long id,
    String skuCode,
    String name,
    String description,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
    public static SkuResponse from(Sku sku){
        return new SkuResponse(
            sku.getId(), 
            sku.getSkuCode(), 
            sku.getName(), 
            sku.getDescription(), 
            sku.getCreatedAt(), 
            sku.getUpdatedAt()
        );

    }
}
