package com.geniecommerce.productcatalog.helpers;

import java.util.List;

import org.mapstruct.Mapper;

import com.geniecommerce.productcatalog.dto.ProductCategoryDTO;
import com.geniecommerce.productcatalog.dto.ProductDTO;
import com.geniecommerce.productcatalog.dto.ProductImageDTO;
import com.geniecommerce.productcatalog.entities.ProductCategoryEntity;
import com.geniecommerce.productcatalog.entities.ProductEntity;
import com.geniecommerce.productcatalog.entities.ProductImageEntities;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	ProductDTO toProductDTO(ProductEntity entity);
    ProductEntity toProductEntity(ProductDTO dto);
    
    List<ProductDTO> toProductDTOList(List<ProductEntity> entityList);
    List<ProductEntity> toProductEntityList(List<ProductDTO> dtoList);
    
    
    ProductCategoryDTO toProductCategoryDTO(ProductCategoryEntity entity);
    ProductCategoryEntity toProductCategoryEntity(ProductCategoryDTO dto);
    
    List<ProductCategoryDTO> toProductCategoryDTOList(List<ProductCategoryEntity> entity);
    List<ProductCategoryEntity> toProductCategoryEntityList(List<ProductCategoryDTO> dto);
    
    
    ProductImageDTO toProductImageDTO(ProductImageEntities entity);
    ProductImageEntities toProductImageEntities(ProductImageDTO dto);
    
    List<ProductImageDTO> toProductImageDTOList(List<ProductImageEntities> entity);
    List<ProductImageEntities> toProductImageEntitiesList(List<ProductImageDTO> dto);

}
