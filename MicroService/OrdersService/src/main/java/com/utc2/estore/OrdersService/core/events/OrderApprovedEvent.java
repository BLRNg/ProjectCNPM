package com.utc2.estore.OrdersService.core.events;

import com.utc2.estore.OrdersService.core.model.OrderStatus;

import lombok.Value;

@Value
public class OrderApprovedEvent {

	private final String orderId;
	private final OrderStatus orderStatus = OrderStatus.APPROVED;
	
}
