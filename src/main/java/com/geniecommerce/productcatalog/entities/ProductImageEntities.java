package com.geniecommerce.productcatalog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_images")
public class ProductImageEntities {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String imageUrl;       // Store S3 path or CDN URL
    private String altText;        // For accessibility
    private Boolean isPrimary;
    private Boolean isMobile;
    private Boolean isBanner;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
