package com.geniecommerce.productcatalog.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record APIResponseDTO(String statusCode, String statusMessage, LocalDateTime timestamp, Map<String, Object> object) {

	
}
