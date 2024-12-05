package org.example.inventoryservice.repo;

import org.example.inventoryservice.entities.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductStockRepository extends JpaRepository<ProductStock,Long> {
    ProductStock findByProductId(String productId);
}
