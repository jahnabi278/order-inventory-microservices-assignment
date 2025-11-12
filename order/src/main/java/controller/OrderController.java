package controller;

import org.springframework.web.bind.annotation.RestController;

import model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")

public class OrderController {
	@Autowired
	service.OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody dto.OrderRequest req) {
		Order o = orderService.placeOrder(req);
		return ResponseEntity.ok(o);
	}

}
