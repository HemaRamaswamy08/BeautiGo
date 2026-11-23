package com.beautigo.notification.service.impl;

import org.springframework.stereotype.Service;

import com.beautigo.notification.model.OrderConfirmedRequest;
import com.beautigo.notification.service.NotificationsService;

@Service
public class NotificationServiceImpl implements NotificationsService{

	  @Override
	    public void sendOrderConfirmedNotification(OrderConfirmedRequest request) {
	        System.out.println("=================================================");
	        System.out.println(">>> NOTIFICATION SERVICE TRIGGERED <<<");
	        System.out.println("Order ID: " + request.getOrderId());
	        System.out.println("Sending confirmation email to Customer: " + request.getCustomerEmail());
	        System.out.println("Sending booking alert to Beautician: " + request.getBeauticianEmail());
	        System.out.println("=================================================");
	    }

}
