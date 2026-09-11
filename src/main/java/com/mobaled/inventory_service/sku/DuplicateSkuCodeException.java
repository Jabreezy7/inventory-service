package com.mobaled.inventory_service.sku;

public class DuplicateSkuCodeException extends RuntimeException {
    public DuplicateSkuCodeException(String skuCode){
        super("SKU Already exists with code: " + skuCode);
    }
}
