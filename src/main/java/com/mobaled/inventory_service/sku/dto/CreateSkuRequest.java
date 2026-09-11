package com.mobaled.inventory_service.sku.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateSkuRequest(

    @NotBlank(message = "skuCode is required")
    @Size(max = 64, message = "skuCode must be at most 64 characters")
    String skuCode,

    @NotBlank(message = "name is required")
    @Size(max = 255, message = "name must be at most 255 characters")
    String name,

    String description
) 
{}
