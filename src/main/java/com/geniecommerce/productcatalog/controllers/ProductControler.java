package com.geniecommerce.productcatalog.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geniecommerce.productcatalog.api.ProductApi;
import com.geniecommerce.productcatalog.constants.OperationStatus;
import com.geniecommerce.productcatalog.dto.APIResponseDTO;
import com.geniecommerce.productcatalog.dto.ProductDTO;
import com.geniecommerce.productcatalog.exceptions.ProductCreationException;
import com.geniecommerce.productcatalog.exceptions.ProductGenericException;
import com.geniecommerce.productcatalog.exceptions.ProductNotfoundException;
import com.geniecommerce.productcatalog.services.service.ProductService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public final class  ProductControler implements ProductApi{
	
	@Autowired
	ProductService productService;
	@Override
	public ResponseEntity<APIResponseDTO> createProduct(@RequestBody @Valid ProductDTO product) {
		System.out.println("testing");
		log.info("chiranjit jasu is testing-----s");
		String skuId=productService.createProduct(product);
		if(null!=skuId) {
			APIResponseDTO response=new APIResponseDTO(
					OperationStatus.SUCCESS.getStatusCode(), OperationStatus.SUCCESS.getStatusMsg(), LocalDateTime.now(),
					Map.of("skuId", skuId));
			return new ResponseEntity<APIResponseDTO>(response,HttpStatus.ACCEPTED);
		}else {
			throw new ProductCreationException();
		}
		
	}

	@Override
	public ResponseEntity<APIResponseDTO> getProduct(String id) {
		
		if (id == null) {
		    throw new ProductGenericException ("ID must not be null");
		}
		 ProductDTO product=productService.getProductById(id);
		 if(null!=product) {
			 APIResponseDTO response=new APIResponseDTO(OperationStatus.SUCCESS.getStatusCode(), OperationStatus.SUCCESS.getStatusMsg(), LocalDateTime.now(), 
					 new HashMap<>() {{put("product", product);}});
			 return new ResponseEntity<APIResponseDTO>(response,HttpStatus.OK);
		 }else {
			 throw new ProductNotfoundException();
		 }
		 
		
		
		
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Void> deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
