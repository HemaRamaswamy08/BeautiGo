package com.beautigo.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beautigo.order.model.Orders;


public interface OrderRepository extends JpaRepository<Orders, Long> {

}
