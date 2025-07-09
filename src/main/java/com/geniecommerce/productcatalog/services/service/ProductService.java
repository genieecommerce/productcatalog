package com.geniecommerce.productcatalog.services.service;

import org.springframework.stereotype.Service;

import com.geniecommerce.productcatalog.dto.ProductDTO;


public interface ProductService {

	public String createProduct(ProductDTO product);
	public ProductDTO getProductById(String productId);
	public ProductDTO updateProduct(ProductDTO product);
	public ProductDTO deactivateProduct(ProductDTO product);
}
