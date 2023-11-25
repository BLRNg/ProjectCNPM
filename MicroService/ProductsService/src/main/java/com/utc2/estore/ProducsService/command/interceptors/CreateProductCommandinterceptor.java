package com.utc2.estore.ProducsService.command.interceptors;

import java.util.List;
import java.util.function.BiFunction;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.utc2.estore.ProducsService.command.CreateProductCommand;
import com.utc2.estore.ProducsService.core.data.ProductLookupEntity;
import com.utc2.estore.ProducsService.core.data.ProductLookupRepository;


@Component
public class CreateProductCommandinterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductCommandinterceptor.class);
	private final ProductLookupRepository productLookupRepository;
	
	public CreateProductCommandinterceptor(ProductLookupRepository productLookupRepository) {
		this.productLookupRepository = productLookupRepository;
	}
 
	@Override
	public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
			List<? extends CommandMessage<?>> messages) {
		 
		return (index, command) -> {
			
			LOGGER.info("Intercepted command: " + command.getPayloadType());
			
			if(CreateProductCommand.class.equals(command.getPayloadType())) {
				
				CreateProductCommand createProductCommand = (CreateProductCommand)command.getPayload();
				
				ProductLookupEntity productLookupEntity =  productLookupRepository.findByProductIdOrTitle(createProductCommand.getProductId(),
						createProductCommand.getTitle());
				
				if(productLookupEntity != null) {
					throw new IllegalStateException(
							String.format("Product with productId %s or title %s already exist", 
									createProductCommand.getProductId(), createProductCommand.getTitle())
							);
				}

			}
			
			return command;
		};
	}

}