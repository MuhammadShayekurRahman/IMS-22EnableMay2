package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {
	
	private Long itemsId;
	private String itemName;
	private double itemCost;
	
	public Items(Long itemsId, String itemName, double itemCost) {
		super();
		this.itemsId = itemsId;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public Items(String itemName, double itemCost) {
		super();
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public Long getItemsId() {
		return itemsId;
	}

	public void setItemsId(Long itemsId) {
		this.itemsId = itemsId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemCost() {
		return itemCost;
	}

	public void setItemCost(double itemCost) {
		this.itemCost = itemCost;
	}

	@Override
	public String toString() {
		return "Items [itemsId=" + itemsId + ", itemName=" + itemName + ", itemCost=" + itemCost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemCost, itemName, itemsId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Double.doubleToLongBits(itemCost) == Double.doubleToLongBits(other.itemCost)
				&& Objects.equals(itemName, other.itemName) && Objects.equals(itemsId, other.itemsId);
	}
	
	
	
	
	

}
