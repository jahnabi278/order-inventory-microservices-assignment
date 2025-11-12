package inventory;

import org.junit.jupiter.api.Test;

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
		InventoryFactoryImpl impl = new InventoryFactoryImpl(repo);
		impl.updateInventory(100, 6); // consumes 5 from b1 and 1 from b2
		verify(repo, atLeastOnce()).save(any());
	}
}
