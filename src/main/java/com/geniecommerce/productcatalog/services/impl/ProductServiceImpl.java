package com.geniecommerce.productcatalog.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.geniecommerce.productcatalog.dto.ProductDTO;
import com.geniecommerce.productcatalog.entities.ProductEntity;
import com.geniecommerce.productcatalog.exceptions.ProductCreationException;
import com.geniecommerce.productcatalog.exceptions.ProductNotfoundException;
import com.geniecommerce.productcatalog.helpers.ProductMapper;
import com.geniecommerce.productcatalog.repositories.ProductRepository;
import com.geniecommerce.productcatalog.services.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	
	private final ProductMapper productMapper;
	private final ProductRepository productRepository;
	
	@Override
	public String createProduct(ProductDTO product) {
		
		log.debug("Product creationn starting");
		if(null!=product && null!=product.getCategory() && null!=product.getCategory().getName()) {
			ProductEntity enitity=productMapper.toProductEntity(product);
			enitity.getImages().forEach(img ->img.setProduct(enitity));
			ProductEntity savedEnitity=productRepository.save(enitity);
			
			String category = enitity.getCategory().getName().trim().replaceAll("\\s+", "").toUpperCase();
			category= category.length() >= 4 ? category.substring(0, 4) : String.format("%-4s", category).replace(' ', '_');
		    savedEnitity.setSkuId("SKU_"+category+"_"+savedEnitity.getId());
		    productRepository.save(savedEnitity);
		    return savedEnitity.getSkuId();
		}else {
			throw new ProductCreationException();
		}
		
		
		
	}

	@Override
	public ProductDTO getProductById(String productId) {
		Optional<ProductEntity> entityPresence= productRepository.findById(Long.valueOf(productId));
		if(entityPresence.isPresent()) {
			ProductDTO product=productMapper.toProductDTO(entityPresence.get());
			return product;
		}else {
			throw new ProductNotfoundException();
		}
	
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO deactivateProduct(ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

}
