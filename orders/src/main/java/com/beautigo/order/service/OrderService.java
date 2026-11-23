package com.beautigo.order.service;

import com.beautigo.order.model.Orders;

public interface OrderService {

	Orders createOrder(Orders order);

	Orders getOrderById(Long id);

}
