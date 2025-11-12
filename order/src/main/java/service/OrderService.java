package service;

import org.springframework.stereotype.Service;

import model.Order;
import repository.OrderRepo;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@Service
public class OrderService {
	private final RestTemplate restTemplate;

	private final OrderRepo orderRepository;
	private final String inventoryUrl = "http://localhost:7080/inventory"; // inventory service

	public OrderService(RestTemplate restTemplate, OrderRepo orderRepository) {
		this.restTemplate = restTemplate;
		this.orderRepository = orderRepository;
	}

	public Order placeOrder(dto.OrderRequest req) {
		String getBatchesUrl = inventoryUrl + "/" + req.getProductId();
		ResponseEntity<?> resp = restTemplate.getForEntity(getBatchesUrl, Object.class);
		Map<String, Integer> update = Map.of("productId", req.getProductId(), "quantity", req.getQuantity());
		restTemplate.postForEntity(inventoryUrl + "/update", update, Map.class);
		Order order = new Order();
		order.setProductId(req.getProductId());
		order.setQuantity(req.getQuantity());
		order.setStatus("PLACED");
		return orderRepository.save(order);
	}

}
