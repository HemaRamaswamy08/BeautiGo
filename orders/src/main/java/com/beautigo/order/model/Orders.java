package com.beautigo.order.model;

import java.math.BigDecimal;

import com.beautigo.order.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "orders")
public class Orders{

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long userId;

	    private Long beauticianId;

	    private Long designId;

	    private BigDecimal price;

	    @Enumerated(EnumType.STRING)
	    private OrderStatus status;
}
