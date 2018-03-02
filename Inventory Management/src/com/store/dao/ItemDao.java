package com.store.dao;

import java.util.List;

import com.store.models.Item;

public interface ItemDao {
	
	public void createItem(String itemName,double costPrice, double sellingPrice);
	public void deleteItem(String itemName);
	public void updateBuy(String itemName, int quantity);
    public void updateSell(String itemName, int quantity);
    public List<Item> getAllItem();
}
