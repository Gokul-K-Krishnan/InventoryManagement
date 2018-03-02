package com.store.models;

import java.util.Comparator;

public class Item {

	private String itemName;
	private int quantity;
	private double costPrice;
	private double sellingPrice;
	
	
	public Item(String itemName, int quantity, double costPrice, double sellingPrice) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	 public static Comparator<Item> ItemComparator = new Comparator<Item>() {

			public int compare(Item item1, Item item2) {
			   String itemName1 = item1.getItemName().toUpperCase();
			   String itemName2 = item2.getItemName().toUpperCase();

			   return itemName1.compareTo(itemName2);
		    }};
}
