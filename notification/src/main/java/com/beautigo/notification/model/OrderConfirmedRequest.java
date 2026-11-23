package com.beautigo.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderConfirmedRequest {

	private Long orderId;

	private Long customerId;
	private String customerEmail;

	private Long beauticianId;
	private String beauticianEmail;

}
