package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.InventoryBatch;
import service.factory.InventoryFactory;

@Service
public class InventoryService {
	@Autowired
	InventoryFactory inventoryFactory;

	public List<InventoryBatch> getBatchesSorted(int productId) {
		return inventoryFactory.getBatches(productId);
	}

	public void reduceInventory(int productId, int qty) {
		inventoryFactory.updateInventory(productId, qty);
	}

}
