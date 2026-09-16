package com.mobaled.inventory_service.sku;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobaled.inventory_service.sku.dto.CreateSkuRequest;
import com.mobaled.inventory_service.sku.dto.SkuResponse;

@Service
public class SkuService {

    private final SkuRepository skuRepository;

    public SkuService(SkuRepository skuRepository) {
        this.skuRepository = skuRepository;
    }

    @Transactional
    public SkuResponse create(CreateSkuRequest request) {
        if (skuRepository.existsBySkuCode(request.skuCode())) {
            throw new DuplicateSkuCodeException(request.skuCode());
        }

        Sku sku = new Sku(request.skuCode(), request.name(), request.description());

        Sku saved = skuRepository.save(sku);
        return SkuResponse.from(saved);
    }

    @Transactional(readOnly = true)
    public SkuResponse getById(Long id){
        Sku sku = skuRepository.findById(id).orElseThrow(() -> new SkuNotFoundException(id));
        return SkuResponse.from(sku);
    }

    @Transactional(readOnly = true)
    public SkuResponse getBySkuCode(String skuCode){
        Sku sku = skuRepository.findBySkuCode(skuCode).orElseThrow(() -> new SkuNotFoundException(skuCode));
        return SkuResponse.from(sku);
    }

}
