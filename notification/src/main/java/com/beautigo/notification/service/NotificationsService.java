package com.beautigo.notification.service;

import com.beautigo.notification.model.OrderConfirmedRequest;

public interface NotificationsService {

	void sendOrderConfirmedNotification(OrderConfirmedRequest request);

}
