package com.geniecommerce.productcatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geniecommerce.productcatalog.entities.ProductEntity;
import com.geniecommerce.productcatalog.entities.ProductImageEntities;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImageEntities, Long> {
    // CRUD methods are auto-generated
}