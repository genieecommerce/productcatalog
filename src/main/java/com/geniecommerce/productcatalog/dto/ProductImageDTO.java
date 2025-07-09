package com.geniecommerce.productcatalog.dto;

import lombok.Data;

@Data
public class ProductImageDTO {
	
    private Long id;
    private String imageUrl;       // Store S3 path or CDN URL
    private String altText;        // For accessibility
    private Boolean isPrimary;
    private Boolean isMobile;
    private Boolean isBanner;
    
    
    
}
