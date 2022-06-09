package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Items {
	
	private Long itemId;
	private String itemName;
	private double itemCost;
	
	public Items(Long itemId, String itemName, double itemCost) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	public Items(String itemName, double itemCost) {
		super();
		this.itemName = itemName;
		this.itemCost = itemCost;
	}
	public Long getItemId() {
		return itemId;
	}
//	public void setItemId(Long itemId) {
//		this.itemId = itemId;
//	}
	public String getItemName() {
		return itemName;
	}
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
	public double getItemCost() {
		return itemCost;
	}
//	public void setItemCost(double itemCost) {
//		this.itemCost = itemCost;
//	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", itemCost=" + itemCost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemCost, itemId, itemName);
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
				&& Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName);
	}
	

	
	

}
