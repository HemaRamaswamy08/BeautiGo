package com.beautigo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beautigo.order.model.Orders;
import com.beautigo.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/create")
	public Orders createOrder(@RequestBody Orders order) {
		return orderService.createOrder(order);
	}

	@GetMapping("/{id}")
	public Orders getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}

}
