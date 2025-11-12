package inventory;

/**import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.InventoryBatch;
import repository.BatchInventoryRepo;
import service.factory.InventoryFactoryImpl;

public class InventoryFactoryImplTest {
	@Test
	void test() {
		BatchInventoryRepo repo = mock(BatchInventoryRepo.class);
		InventoryBatch b1 = new InventoryBatch(); // assume setters present
		b1.setId(1);
		b1.setQuantity(5);
		b1.setExpiryDate(LocalDate.now().plusDays(1));

		InventoryBatch b2 = new InventoryBatch();
		b2.setId(2);
		b2.setQuantity(5);
		b2.setExpiryDate(LocalDate.now().plusDays(10));

		when(repo.findByIdOrderByExpiry(100)).thenReturn(List.of(b1, b2));
		new InventoryFactoryImpl().updateInventory(100, 6); // consumes 5 from b1 and 1 from b2
		verify(repo, atLeastOnce()).save(any());
	}
}**/
