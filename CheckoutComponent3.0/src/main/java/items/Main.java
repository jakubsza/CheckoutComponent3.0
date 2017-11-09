package items;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import helpers.ItemsHelper;

public class Main{
	
	private List<Item> itemsList;
	
	public void setUpItems(){
		List<Item> itemsList = new ArrayList<Item>();
		File file;
	    try {
	    	file = new File("C:\\Users\\Jakub\\Desktop\\KUBA\\praca\\java\\projekty&programy\\CheckoutComponent\\Items.txt");
			Scanner in = new Scanner(file);
			while(in.hasNextLine()){
				String[] values = ItemsHelper.getValues(in.nextLine());
				itemsList.add(new Item(values[0],Double.parseDouble(values[1]),Integer.parseInt(values[2]),Double.parseDouble(values[3])));
				}

		} catch (FileNotFoundException e) {
			
		}
		this.itemsList=itemsList;
	}
	
	public List<Item> getItemList(){
		return itemsList;
	}
	


}
