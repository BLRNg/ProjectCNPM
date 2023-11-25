/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utc2.estore.PaymentsService.events;


import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.utc2.estore.PaymentsService.data.PaymentEntity;
import com.utc2.estore.PaymentsService.data.PaymentRepository;
import com.utc2.estore.core.events.PaymentProcessedEvent;

@Component
public class PaymentEventsHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(PaymentEventsHandler.class);
    private final PaymentRepository paymentRepository;

    public PaymentEventsHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        LOGGER.info("PaymentProcessedEvent is called for orderId: " + event.getOrderId());

        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(event, paymentEntity);
        try {
        	paymentRepository.save(paymentEntity);
        } catch (Exception e) {
        	LOGGER.error("Loi");
        	LOGGER.error(e.getMessage());
		}
        

    }
}
