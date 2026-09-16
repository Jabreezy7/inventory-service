package com.mobaled.inventory_service.sku;

public class SkuNotFoundException extends RuntimeException {
    public SkuNotFoundException(Long id){
        super("SKU not found with id: " +  id);
    }

    public SkuNotFoundException(String skuCode){
        super("SKU not found with skuCode: " + skuCode);
    }
    
}
