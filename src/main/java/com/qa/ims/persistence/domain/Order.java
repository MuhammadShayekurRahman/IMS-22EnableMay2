package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private long orderId;
	private Customer customer;
	private long costs;
	
	
	public Order(long orderId, Customer customer,long costs) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.costs = costs;
	}
	
	
	
	public Order(long orderId, Customer customer) {
		super();
		this.orderId = orderId;
		this.customer = customer;
	}



	public Order(Customer customer, long costs) {
		super();
		this.customer = customer;
		this.costs = costs;
	}
	
	
	
	
	public Order(Customer customer) {
		super();
		this.customer = customer;
	}
	public long getCosts() {
		return costs;
	}
	public void setCosts(long costs) {
		this.costs = costs;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", costs=" + costs + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(costs, customer, orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return costs == other.costs && Objects.equals(customer, other.customer) && orderId == other.orderId;
	}
	
	
	
	
}
