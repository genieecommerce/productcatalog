package com.geniecommerce.productcatalog.dto;

import java.time.LocalDateTime;

public record APIErrorDTO(String statusCode, String statusMessage,String supportMessage, LocalDateTime timestamp) {

}
