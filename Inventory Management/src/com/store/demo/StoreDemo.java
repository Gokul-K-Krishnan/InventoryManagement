package com.store.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import com.store.dao.ItemDaoImpl;
import com.store.models.Item;

import java.text.DecimalFormat;

public class StoreDemo {

	private static DecimalFormat df = new DecimalFormat(".##");

	public static void main(String[] args) throws IOException {

		ItemDaoImpl itemDao = new ItemDaoImpl();
		Boolean flag = true;

		double cost_of_delelted_item;

		while (flag) {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();

			String[] stringList = input.split(" ");

			if (stringList[0].contains("create")) {
				itemDao.createItem(stringList[1], Double.parseDouble(stringList[2]), Double.parseDouble(stringList[3]));
			}

			if (stringList[0].contains("updateBuy")) {
				itemDao.updateBuy(stringList[1], Integer.parseInt(stringList[2]));
			}

			if (stringList[0].contains("updateSell")) {
				itemDao.updateSell(stringList[1], Integer.parseInt(stringList[2]));
			}

			if (stringList[0].contains("delete")) {
				itemDao.deleteItem(stringList[1]);
			}

			if (stringList[0].contains("report")) {

				System.out.println("\t\tInventory Management");
				System.out.println("Item Name \t Bought At \t Sold At \t AvailableQty \t Value");

				List<Item> ItemList = itemDao.getAllItem();
				Collections.sort(ItemList, Item.ItemComparator);

				double totalValue = 0;
				double profit = 0;

				for (Item item : ItemList) {
					System.out.print(item.getItemName() + "\t\t" + df.format(item.getCostPrice()) + "\t\t"
							+ df.format(item.getSellingPrice()) + "\t\t" + item.getQuantity() + "\t\t");
					System.out.println(df.format(item.getSellingPrice() * item.getQuantity()));
					totalValue += item.getSellingPrice() * item.getQuantity();
					if (itemDao.checkDeletedItem(item.getItemName())) {
						cost_of_delelted_item = item.getCostPrice();
					} else {
						cost_of_delelted_item = 0.0;
					}
					profit += ((item.getCostPrice() - item.getSellingPrice())
							* (itemDao.getNumberOfSoldItems(item.getItemName()) - cost_of_delelted_item));
				}

				System.out.println("Total Value\t\t\t" + totalValue);
				System.out.println("Profit\t\t\t" + profit);
			}

			if (stringList[0].contains("#")) {
				flag = false;
			}
		}
	}
}
