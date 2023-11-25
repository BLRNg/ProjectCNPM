package com.utc2.estore.ProducsService.query.rest;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRestModel {

	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
	
	public ProductRestModel() {
	}
	
	
	
}
