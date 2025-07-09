package com.geniecommerce.productcatalog.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.geniecommerce.productcatalog.constants.OperationStatus;
import com.geniecommerce.productcatalog.dto.APIErrorDTO;

@ControllerAdvice
public class ProductExceptionHandler {

	@ExceptionHandler(ProductCreationException.class)
    public ResponseEntity<APIErrorDTO> handleProductCreation(ProductCreationException ex) {
        APIErrorDTO error = new APIErrorDTO(OperationStatus.BUSINESS_FAIL.getStatusCode(),OperationStatus.BUSINESS_FAIL.getStatusMsg(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<APIErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ProductNotfoundException.class)
    public ResponseEntity<APIErrorDTO> handleProductNotfoundCreation(ProductNotfoundException ex) {
        APIErrorDTO error = new APIErrorDTO(OperationStatus.BUSINESS_FAIL.getStatusCode(),OperationStatus.BUSINESS_FAIL.getStatusMsg(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<APIErrorDTO>(error, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(ProductGenericException.class)
    public ResponseEntity<APIErrorDTO> handleProductGenericException(ProductGenericException ex) {
        APIErrorDTO error = new APIErrorDTO(OperationStatus.BUSINESS_FAIL.getStatusCode(),OperationStatus.BUSINESS_FAIL.getStatusMsg(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<APIErrorDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIErrorDTO> handleGeneralException(Exception ex) {
    	APIErrorDTO error = new APIErrorDTO(OperationStatus.TECHNICAL_FAIL.getStatusCode(), OperationStatus.TECHNICAL_FAIL.getStatusMsg(),ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<APIErrorDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
