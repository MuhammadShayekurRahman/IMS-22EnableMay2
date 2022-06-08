package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Costs {
	
	private Long orderId;
	private Long cost;
	
	public Costs(Long orderId, Long cost) {
		super();
		this.orderId = orderId;
		this.cost = cost;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Costs [orderId=" + orderId + ", cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costs other = (Costs) obj;
		return Objects.equals(cost, other.cost) && Objects.equals(orderId, other.orderId);
	}
	
	
	

}
