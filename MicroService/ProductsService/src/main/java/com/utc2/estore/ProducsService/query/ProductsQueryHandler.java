package com.utc2.estore.ProducsService.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.utc2.estore.ProducsService.core.data.ProductEntity;
import com.utc2.estore.ProducsService.core.data.ProductRepository;
import com.utc2.estore.ProducsService.query.rest.ProductRestModel;

@Component
public class ProductsQueryHandler {
	
private final ProductRepository productsRepository;
	
	public ProductsQueryHandler(ProductRepository productsRepository) {
		this.productsRepository = productsRepository;
	}
	
	@QueryHandler
	public List<ProductRestModel> findProducts(FindProductsQuery query) {
		
		List<ProductRestModel> productsRest = new ArrayList<>();
		
		List<ProductEntity> storedProducts =  productsRepository.findAll();
		
		for(ProductEntity productEntity: storedProducts) {
			ProductRestModel productRestModel = new ProductRestModel();
			BeanUtils.copyProperties(productEntity, productRestModel);
			productsRest.add(productRestModel);
		}
		
		return productsRest;
		
	}
}
