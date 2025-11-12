package service;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	@Autowired
	InventoryFactory inventoryFactory;

	  public List<InventoryBatch> getBatchesSorted(Long productId) {
	    return inventoryFactory.getBatches(productId);
	  }

	  public void reduceInventory(Long productId, int qty) {
		  inventoryFactory.updateInventoryAfterOrder(productId, qty);
	  }

}
