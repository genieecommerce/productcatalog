package com.geniecommerce.productcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geniecommerce.productcatalog.entities.ProductCategoryEntity;
import com.geniecommerce.productcatalog.entities.ProductEntity;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
    // CRUD methods are auto-generated
}