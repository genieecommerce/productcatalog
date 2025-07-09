package com.geniecommerce.productcatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCategoryDTO {
	private Long id;

	@NotBlank
	@Size(min = 4, max = 50)
	private String name;
	@NotBlank
	@Size(min = 4, max = 50)
	private String code;

}
