package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
