package com.utc2.estore.ProducsService.core.errorhandling;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
	
	private final Date timestamp;
	private final String message;

}
