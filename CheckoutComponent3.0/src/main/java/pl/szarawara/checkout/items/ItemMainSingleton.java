package pl.szarawara.checkout.items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pl.szarawara.checkout.helpers.ItemsHelper;

public class ItemMainSingleton {

	private Map<String, Item> itemsMap;
	private static ItemMainSingleton instance = null;
			
	public static ItemMainSingleton getinstance(){
		if(instance == null){
			instance = new ItemMainSingleton();
		}
		return instance;
	}
	
	
	private ItemMainSingleton() {
		Map<String, Item> itemsMap = new HashMap<String, Item>();
		File file;
		try {
			file = new File("Items.txt");
					//"C:\\Users\\Jakub\\Desktop\\KUBA\\praca\\java\\projekty&programy\\CheckoutComponent\\Items.txt");
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String[] values = ItemsHelper.getValues(in.nextLine());
				String key = values[0];
				double priceValue = Double.parseDouble(values[1]);
				int unitValue = Integer.parseInt(values[2]);
				double specialPriceValue = Double.parseDouble(values[3]);

				Item itemValue = new Item(priceValue, unitValue, specialPriceValue);

				itemsMap.put(key, itemValue);
			}

		} catch (FileNotFoundException e) {

		}
		this.itemsMap = itemsMap;
	}

	public Map<String, Item> getItemMap() {
		return itemsMap;
	}

}
