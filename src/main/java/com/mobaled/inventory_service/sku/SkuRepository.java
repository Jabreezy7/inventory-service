package com.mobaled.inventory_service.sku;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepository extends JpaRepository<Sku, Long> {
    
    Optional<Sku> findBySkuCode(String skuCode);

    boolean existsBySkuCode(String skuCode);
}
