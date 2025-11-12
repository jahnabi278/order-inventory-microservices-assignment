package controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")

public class InventoryController {
	private final service.InventoryService inventoryService;

	public InventoryController(service.InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@GetMapping("/{productId}")
	public ResponseEntity<List<model.InventoryBatch>> getBatches(@PathVariable int productId) {
		return ResponseEntity.ok(inventoryService.getBatchesSorted(productId));
	}

	@PostMapping("/update")
	public ResponseEntity<Map<String, String>> updateAfterOrder(@RequestBody UpdateRequest req) {
		inventoryService.reduceInventory(req.getProductId(), req.getQuantity());
		return ResponseEntity.ok(Map.of("status", "ok"));
	}

	public static class UpdateRequest {
		private int productId;
		private int quantity;

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

	}
}
