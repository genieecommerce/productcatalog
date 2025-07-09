package com.geniecommerce.productcatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductImageDTO {
	
    private Long id;
    @NotBlank
	@Size(min = 5, max = 200)
    private String imageUrl;       // Store S3 path or CDN URL
    private String altText;        // For accessibility
    private Boolean isPrimary;
    private Boolean isMobile;
    private Boolean isBanner;
    
    
    
}
