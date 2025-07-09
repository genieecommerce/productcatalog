package com.geniecommerce.productcatalog.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geniecommerce.productcatalog.dto.APIResponseDTO;
import com.geniecommerce.productcatalog.dto.ProductDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/api/products")
public interface ProductApi {

    @Operation(summary = "Create a new product")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product created successfully",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = """
                    {
                      "id": 101,
                      "name": "Wireless Mouse",
                      "description": "Ergonomic wireless mouse",
                      "price": 29.99
                    }
                    """
                )
            )
        )
    })
    @PostMapping(consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    public ResponseEntity<APIResponseDTO> createProduct(@RequestBody ProductDTO product);

    @Operation(summary = "Get product by ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Product retrieved",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = """
                    {
                      "id": 101,
                      "name": "Wireless Mouse",
                      "description": "Ergonomic wireless mouse",
                      "price": 29.99
                    }
                    """
                )
            )
        ),
        @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    ResponseEntity<APIResponseDTO>  getProduct(@PathVariable String id);

    @Operation(summary = "Update product details")
    @ApiResponse(responseCode = "200", description = "Product updated successfully")
    @PutMapping(value = "/{id}", consumes = {"application/json", "application/xml"}, produces = {"application/json", "application/xml"})
    ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO product);

    @Operation(summary = "Delete or deactivate product")
    @ApiResponse(responseCode = "204", description = "Product deleted or deactivated")
    @DeleteMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    ResponseEntity<Void> deleteProduct(@PathVariable Long id);
    
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
    ResponseEntity<APIResponseDTO>  update(@PathVariable String id);
    
    
}

