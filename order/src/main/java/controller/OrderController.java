package controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.order.dto.OrderRequest;
import com.example.order.model.OrderEntity;
import com.example.order.service.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/order")

public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest req) {
		OrderEntity o = orderService.placeOrder(req);
		return ResponseEntity.ok(o);
	}

}
