package service.factory;

import java.util.List;

import model.InventoryBatch;

public interface InventoryFactory {
	List<InventoryBatch> getBatches(int id);

	int updateInventory(int id, int quant);
}
