package com.utc2.estore.OrdersService.core.events;

import com.utc2.estore.OrdersService.core.model.OrderStatus;

import lombok.Value;

@Value
public class OrderRejectedEvent {

	private final String orderId;
	private final String reason;
	private final OrderStatus orderStatus = OrderStatus.REJECTED;
}
