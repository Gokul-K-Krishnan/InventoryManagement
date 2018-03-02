package com.store.dao;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.store.models.Item;
import com.store.models.ItemRecords;

public class ItemDaoImpl implements ItemDao,ItemRecordsDao{
	
	Hashtable<String, Item> itemList  = new Hashtable<String, Item>();
	Hashtable<String, ItemRecords> itemRecordsList  = new Hashtable<String, ItemRecords>();
	
	
	@Override
	public void createItem(String itemName, double costPrice, double sellingPrice) {
	      
		Item item = new Item(itemName,0,costPrice,sellingPrice);
	    itemList.put(itemName, item);
	      
	    ItemRecords itemRecords = new ItemRecords(itemName, 0,false,0);  
	    itemRecordsList.put(itemName,itemRecords);
	}

	@Override
	public void deleteItem(String itemName) {
		itemList.remove(itemName);
		
		ItemRecords itemRecords = itemRecordsList.get(itemName);
		itemRecords.setItems_deleted(true);
		itemRecordsList.replace(itemName, itemRecords);
	}

	@Override
	public void updateBuy(String itemName, int quantity) {
		Item item = itemList.get(itemName);
		item.setQuantity(item.getQuantity() + quantity);
		itemList.replace(itemName, item);
	}

	@Override
	public void updateSell(String itemName, int quantity) {
		Item item = itemList.get(itemName);
		item.setQuantity(item.getQuantity() - quantity);
		itemList.replace(itemName, item);
		
		ItemRecords itemRecords = itemRecordsList.get(itemName);
		itemRecords.setNo_items_sold(itemRecords.getNo_items_sold()+quantity);
		itemRecordsList.replace(itemName, itemRecords);
	}

	@Override
	public List<Item> getAllItem() {
	    List<Item> itemAllList = new ArrayList<Item>(itemList.values());
		return itemAllList;
	}

	@Override
	public int getNumberOfSoldItems(String ItemName) {
		ItemRecords itemRecords =  itemRecordsList.get(ItemName);
		return itemRecords.getNo_items_sold();
		
	}

	@Override
	public double getPrevoiusSellingPrice(String ItemName) {
		ItemRecords itemRecords =  itemRecordsList.get(ItemName);
		return itemRecords.getPrevious_selling_price();
		
	}

	@Override
	public boolean checkDeletedItem (String ItemName) {
		ItemRecords itemRecords =  itemRecordsList.get(ItemName);
	    return itemRecords.getItems_deleted();
		
	}

}
