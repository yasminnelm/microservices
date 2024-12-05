package com.example.order.service;

import com.example.order.entity.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCT",url = "http://localhost:8080")
public interface ProduitService {
    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> getProductById(@PathVariable String id);
}
