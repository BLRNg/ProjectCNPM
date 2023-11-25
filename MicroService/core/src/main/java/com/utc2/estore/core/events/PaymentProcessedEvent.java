package com.utc2.estore.core.events;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
@AllArgsConstructor
public class PaymentProcessedEvent {
    private final String orderId;
    
    @TargetAggregateIdentifier
    private final String paymentId;
}
