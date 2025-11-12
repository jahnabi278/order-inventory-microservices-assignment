package service.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import model.InventoryBatch;
import repository.BatchInventoryRepo;

@Component
public class InventoryFactoryImpl implements InventoryFactory {
	@Autowired
	BatchInventoryRepo inventoryBatchRepo;

	@Override
	public List<InventoryBatch> getBatches(int id) {

		return inventoryBatchRepo.findByIdOrderByExpiry(id);
	}

	@Override
	@Transactional
	public int updateInventory(int id, int quant) {
		int updated = 0;
		List<InventoryBatch> inventoryBatches = inventoryBatchRepo.findByIdOrderByExpiry(id);
		for (InventoryBatch inventoryBatch : inventoryBatches) {
			if (quant <= 0) {
				updated = -1;// nothing to update
			}
			int available = Math.min(inventoryBatch.getQuantity(), quant);
			inventoryBatch.setQuantity(inventoryBatch.getQuantity() - available);
			quant = quant - available;
			inventoryBatchRepo.save(inventoryBatch);

		}
		return updated;
	}

}
