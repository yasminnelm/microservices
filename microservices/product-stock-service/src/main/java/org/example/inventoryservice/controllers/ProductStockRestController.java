package org.example.inventoryservice.controllers;

import org.example.inventoryservice.entities.ProductStock;
import org.example.inventoryservice.repo.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class ProductStockRestController {

    private final ProductStockRepository productStockRepository;

    public ProductStockRestController(ProductStockRepository productStockRepository) {
        this.productStockRepository = productStockRepository;
    }

    // Endpoint to charge the stock
    @PostMapping("/charge")
    public ResponseEntity<?> chargeStock(@RequestParam String productId, @RequestParam int quantity) {
        ProductStock productStock = productStockRepository.findByProductId(productId);
        if (productStock == null) {
            return ResponseEntity.badRequest().body("Product not found");
        }
        productStock.setQuantity(productStock.getQuantity() + quantity);
        productStockRepository.save(productStock);
        return ResponseEntity.ok(productStock);
    }

    // Endpoint to decrement the stock
    @PostMapping("/decrement")
    public ResponseEntity<?> decrementStock(@RequestParam String productId, @RequestParam int quantity) {
        ProductStock productStock = productStockRepository.findByProductId(productId);
        if (productStock == null) {
            return ResponseEntity.badRequest().body("Product not found");
        }
        if (productStock.getQuantity() < quantity) {
            return ResponseEntity.badRequest().body("Not enough stock available");
        }
        productStock.setQuantity(productStock.getQuantity() - quantity);
        productStockRepository.save(productStock);
        return ResponseEntity.ok(productStock);
    }
}
