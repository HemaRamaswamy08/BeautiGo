package com.beautigo.order.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.beautigo.order.enums.OrderStatus;
import com.beautigo.order.model.BeauticianDTO;
import com.beautigo.order.model.DesignDTO;
import com.beautigo.order.model.NotificationRequest;
import com.beautigo.order.model.Orders;
import com.beautigo.order.model.UsersDTO;
import com.beautigo.order.repo.OrderRepository;
import com.beautigo.order.service.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final OrderRepository orderRepository;
	private final RestTemplate restTemplate;

	@Override
	public Orders createOrder(Orders order) {
		
	    // 1. REST Call to Users Service (Port 8082)
        String userUrl = "http://localhost:8082/customers/" + order.getUserId();
        UsersDTO user = restTemplate.getForObject(userUrl, UsersDTO.class);
        if (user == null) {
            throw new RuntimeException("Customer not found with ID: " + order.getUserId());
        }
        // 2. REST Call to Customer (Beautician) Service (Port 8081)
        String beauticianUrl = "http://localhost:8081/beautician/" + order.getBeauticianId();
        BeauticianDTO beautician = restTemplate.getForObject(beauticianUrl, BeauticianDTO.class);
        if (beautician == null) {
            throw new RuntimeException("Beautician not found with ID: " + order.getBeauticianId());
        }
        String designUrl = "http://localhost:8081/beautician/design/design/" + order.getDesignId();
        DesignDTO design = restTemplate.getForObject(designUrl, DesignDTO.class);
        if (design == null) {
            throw new RuntimeException("Design not found with ID: " + order.getDesignId());
        }
        // 3. Set the verified price from design & status
        order.setPrice(design.getPrice());
        order.setStatus(OrderStatus.CREATED);
        Orders savedOrder = orderRepository.save(order);
        // 4. REST Call to Notification Service (Port 8083)
        String notificationUrl = "http://localhost:8083/notification/order-confirmed";
        NotificationRequest notification = new NotificationRequest(
            savedOrder.getId(),
            user.getId(),
            user.getEmail(),
            beautician.getId(),
            beautician.getEmail()
        );
        restTemplate.postForObject(notificationUrl, notification, String.class);
        return savedOrder;
	}

	@Override
	public Orders getOrderById(Long id) {

		return orderRepository.findById(id).orElse(null);
	}
}
