package com.beautigo.order.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DesignDTO {
	private Long id;
	private String name;
	private BigDecimal price;
}