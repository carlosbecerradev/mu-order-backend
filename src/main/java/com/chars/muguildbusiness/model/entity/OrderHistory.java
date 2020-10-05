package com.chars.muguildbusiness.model.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders_history")
public class OrderHistory implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long order_history_id;
	private Long mate_id;
	private String price;
	private String observation;
	private Instant created;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order order;

	public Long getOrder_history_id() {
		return order_history_id;
	}

	public void setOrder_history_id(Long order_history_id) {
		this.order_history_id = order_history_id;
	}

	public Long getMate_id() {
		return mate_id;
	}

	public void setMate_id(Long mate_id) {
		this.mate_id = mate_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(Instant created) {
		this.created = created;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
