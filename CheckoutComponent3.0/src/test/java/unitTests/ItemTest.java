package unitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import items.Item;
import items.Main;

public class ItemTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void scanningFile(){
		Main main = new Main();
		main.setUpItems();
		List<Item> testItemsList = main.getItemList();
		List<Item> myItemList = new ArrayList<Item>();
		
		Item itemA = new Item("A",40.0,3,70.0);
		Item itemB = new Item("B",10.0,2,15.0);
		Item itemC = new Item("C",30.0,4,60.0);
		Item itemD = new Item("D",25.0,2,40.0);
		
		myItemList.add(itemA);
		myItemList.add(itemB);
		myItemList.add(itemC);
		myItemList.add(itemD);

		for (int i=0; i<4; i++){
			assertEquals(myItemList.get(i).getName(),testItemsList.get(i).getName());
			assertEquals(myItemList.get(i).getPrice(),testItemsList.get(i).getPrice(),DELTA);
			assertEquals(myItemList.get(i).getSpecialPrice(),testItemsList.get(i).getSpecialPrice(),DELTA);
			assertEquals(myItemList.get(i).getUnit(),testItemsList.get(i).getUnit());
		}
		
	}
}
