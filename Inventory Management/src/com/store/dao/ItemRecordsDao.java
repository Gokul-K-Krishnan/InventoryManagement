package com.store.dao;

public interface ItemRecordsDao {
	
	public int getNumberOfSoldItems(String itemName);
	public double getPrevoiusSellingPrice(String itemName);
	public boolean checkDeletedItem(String itemName);

}
