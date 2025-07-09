package com.geniecommerce.productcatalog.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.geniecommerce.productcatalog.entities.ProductImageEntities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Represents a product in the catalog")
public class ProductDTO {

	@Schema(description = "Unique identifier of the product", example = "101")
	private Long id;

	@Schema(description = "Stock Keeping Unit ID", example = "SKU-LOGI-001")
	private String skuId;

	@NotBlank
	@Size(min = 5, max = 200)
	@Schema(description = "Name of the product", example = "Wireless Mouse")
	private String name;

	
	@Size(min = 5, max = 500)
	@Schema(description = "Detailed description of the product", example = "Ergonomic wireless mouse with adjustable DPI")
	private String description;

	@DecimalMin("0.0")
	@Schema(description = "Price of the product", example = "29.99")
	private double price;

	@Size(min = 5, max = 50)
	@Schema(description = "Country of origin", example = "India")
	private String origin;

	
	private Map<String, String> attributes;
	
	
	private ProductCategoryDTO category;
	private List<ProductImageDTO> images;
}
