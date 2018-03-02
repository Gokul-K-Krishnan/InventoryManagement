package com.store.models;

public class ItemRecords {

	private String itemName;
	private int no_items_sold;
	private boolean items_deleted;
	private int previous_selling_price;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getNo_items_sold() {
		return no_items_sold;
	}

	public void setNo_items_sold(int no_items_sold) {
		this.no_items_sold = no_items_sold;
	}

	public boolean getItems_deleted() {
		return items_deleted;
	}

	public void setItems_deleted(boolean items_deleted) {
		this.items_deleted = items_deleted;
	}

	public int getPrevious_selling_price() {
		return previous_selling_price;
	}

	public void setPrevious_selling_price(int previous_selling_price) {
		this.previous_selling_price = previous_selling_price;
	}

	public ItemRecords(String itemName, int no_items_sold, boolean items_deleted, int previous_selling_price) {
		this.itemName = itemName;
		this.no_items_sold = no_items_sold;
		this.items_deleted = items_deleted;
		this.previous_selling_price = previous_selling_price;
	}
}
