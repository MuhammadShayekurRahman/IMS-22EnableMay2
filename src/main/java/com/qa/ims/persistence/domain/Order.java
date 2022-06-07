package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Order {

	private long orderId;
	private Customer customer;
	
	
	public Order(long orderId, Customer customer) {
		super();
		this.orderId = orderId;
		this.customer = customer;
	}
	public Order(Customer customer) {
		super();
		this.customer = customer;
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
		return "Order [orderId=" + orderId + ", customer=" + customer + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer, orderId);
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
		return Objects.equals(customer, other.customer) && orderId == other.orderId;
	}
	
	
	
}
