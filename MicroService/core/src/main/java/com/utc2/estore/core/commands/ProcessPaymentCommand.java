package com.utc2.estore.core.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.utc2.estore.core.model.PaymentDetails;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProcessPaymentCommand {

	@TargetAggregateIdentifier
	private final String paymentId;
	private final String orderId;
	private final PaymentDetails paymentDetails;
	
}