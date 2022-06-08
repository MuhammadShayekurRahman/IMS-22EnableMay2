package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItems {
	
	private Long orderItemsId;
	private Long quantity;
	private Order order;
	private Items items;
	
	public OrderItems(Long orderItemsId, Long quantity, Order order, Items items) {
		super();
		this.orderItemsId = orderItemsId;
		this.quantity = quantity;
		this.order = order;
		this.items = items;
	}

	public OrderItems(Long quantity, Order order, Items items) {
		super();
		this.quantity = quantity;
		this.order = order;
		this.items = items;
	}

	public Long getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(Long orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public double orderCost() {
		
		
	
		double x = quantity * items.getItemCost();
		return x;
	}
	
	
	@Override
	public String toString() {
		return   order + ", "
				+ items+", quantity=" + quantity + " [ORDER COST: "+ orderCost() + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, order, orderItemsId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItems other = (OrderItems) obj;
		return Objects.equals(items, other.items) && Objects.equals(order, other.order)
				&& Objects.equals(orderItemsId, other.orderItemsId) && Objects.equals(quantity, other.quantity);
	}
	
	

}
