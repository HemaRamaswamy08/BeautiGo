package com.beautigo.notification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beautigo.notification.model.OrderConfirmedRequest;
import com.beautigo.notification.service.NotificationsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("notification/")
public class NotificationController {
	
	   private final NotificationsService notificationService;

	    @PostMapping("/order-confirmed")
	    public ResponseEntity<String> orderConfirmed(
	            @RequestBody OrderConfirmedRequest request) {

	        notificationService.sendOrderConfirmedNotification(request);

	        return ResponseEntity.ok(
	                "Order confirmation notifications sent");
	    }

}
