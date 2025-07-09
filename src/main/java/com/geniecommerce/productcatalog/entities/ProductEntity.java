package com.geniecommerce.productcatalog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
@Schema(description = "Represents a product in the catalog")
@SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", initialValue = 1000, // 👈 Start from 1000
		allocationSize = 1 // 👈 Increment by 1
)
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@Schema(description = "Unique identifier of the product", example = "101")
	private Long id;

	
	@Schema(description = "Stock Keeping Unit ID", example = "SKU-LOGI-001")
	private String skuId;

	@NotBlank
	@Schema(description = "Name of the product", example = "Wireless Mouse")
	private String name;

	@Schema(description = "Detailed description of the product", example = "Ergonomic wireless mouse with adjustable DPI")
	private String description;

	@Schema(description = "Color of the product", example = "Black")
	private String color;

	@DecimalMin("0.0")
	@Schema(description = "Price of the product", example = "29.99")
	private double price;

	@Schema(description = "Country of origin", example = "India")
	private String origin;
	
	private Boolean isActive;

	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductAttributesEntity> attributes;
	
	@Schema(description = "Product category", example = "Electronics")
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private ProductCategoryEntity category;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImageEntities> images;
}
