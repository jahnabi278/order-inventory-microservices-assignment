package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.InventoryBatch;
@Repository
public interface BatchInventoryRepo extends JpaRepository<InventoryBatch, Integer> {
	List<InventoryBatch> findByIdOrderByExpiry(int id);
}
