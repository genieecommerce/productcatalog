package com.geniecommerce.productcatalog.constants;

import lombok.Getter;

@Getter
public enum OperationStatus {

	SUCCESS("S001", "Operation completed successfully"),
	BUSINESS_FAIL("B001", "Business rule violation"),
	TECHNICAL_FAIL("T001", "System or infrastructure error");

	private final String statusCode;
	private final String statusMsg;
	private OperationStatus(String statusCode, String statusMsg) {
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}


	
}
