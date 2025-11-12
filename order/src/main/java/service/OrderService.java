package service;

import org.springframework.stereotype.Service;
import com.example.order.dto.OrderRequest;
import com.example.order.model.OrderEntity;
import com.example.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;

@Service
public class OrderService {
	private final RestTemplate restTemplate;
	
	  private final OrderRepository orderRepository;
	  private final String inventoryUrl = "http://localhost:7080/inventory"; // inventory service

	  public OrderService(RestTemplate restTemplate, OrderRepository orderRepository) {
	    this.restTemplate = restTemplate;
	    this.orderRepository = orderRepository;
	  }

	  public OrderEntity placeOrder(OrderRequest req) {
	    // 1) check availability (get batches)
	    String getBatchesUrl = inventoryUrl + "/" + req.getProductId();
	    ResponseEntity<?> resp = restTemplate.getForEntity(getBatchesUrl, Object.class);
	    // We keep check simple: assume available and call update endpoint; in real system parse qty;
	    // 2) update inventory after confirming
	     update = Map.of("productId", req.getProductId(), "quantity", req.getQuantity());
	    restTemplate.postForEntity(inventoryUrl + "/update", update, Map.class);

	    // 3) persist order
	    OrderEntity order = new OrderEntity();
	    order.setProductId(req.getProductId());
	    order.setQuantity(req.getQuantity());
	    order.setStatus("PLACED");
	    return orderRepository.save(order);
	  }

}
