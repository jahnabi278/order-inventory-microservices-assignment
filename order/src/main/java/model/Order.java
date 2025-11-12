package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int productId;
	private int quantity;
	private String status;
	private LocalDateTime craetedAt = LocalDateTime.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCraetedAt() {
		return craetedAt;
	}

	public void setCraetedAt(LocalDateTime craetedAt) {
		this.craetedAt = craetedAt;
	}

}
