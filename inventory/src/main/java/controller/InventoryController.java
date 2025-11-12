package controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.inventory.model.InventoryBatch;
import com.example.inventory.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventory")

public class InventoryController {
	private final InventoryService inventoryService;
	  public InventoryController(InventoryService inventoryService) {
	    this.inventoryService = inventoryService;
	  }

	  @GetMapping("/{productId}")
	  public ResponseEntity<List<InventoryBatch>> getBatches(@PathVariable int productId) {
	    return ResponseEntity.ok(inventoryService.getBatchesSorted(productId));
	  }

	  @PostMapping("/update")
	  public ResponseEntity<Map<String, String>> updateAfterOrder(@RequestBody UpdateRequest req) {
	    inventoryService.reduceInventory(req.getProductId(), req.getQuantity());
	    return ResponseEntity.ok(Map.of("status","ok"));
	  }

	  public static class UpdateRequest {
	    private id productId;
	    private int quantity;
	    // getters/setters
	    public id getProductId(){ return productId; }
	    public void setProductId(id p){ this.productId = p; }
	    public Integer getQuantity(){ return quantity; }
	    public void setQuantity(int q){ this.quantity = q; }
	  }
}
