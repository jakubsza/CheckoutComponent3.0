package pl.szarawara.checkout.unitTests;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import pl.szarawara.checkout.items.Item;
import pl.szarawara.checkout.items.ItemMainSingleton;

public class ItemTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void scanningFile(){
		ItemMainSingleton main = ItemMainSingleton.getinstance();
		
		Map<String, Item> testItemsMap = main.getItemMap();
		Map<String, Item> myItemMap = new HashMap<String, Item>();
		
		Item itemA = new Item(40.0,3,70.0);
		Item itemB = new Item(10.0,2,15.0);
		Item itemC = new Item(30.0,4,60.0);
		Item itemD = new Item(25.0,2,40.0);
		
		
		
		myItemMap.put("A", itemA);
		myItemMap.put("B", itemB);
		myItemMap.put("C", itemC);
		myItemMap.put("D", itemD);

		int checkingNumber=0;
		for (Map.Entry<String, Item> entry : myItemMap.entrySet()){
			String key = entry.getKey();
			Item value = entry.getValue();
			if(testItemsMap.containsKey(key)){
				assertEquals(value.getPrice(),testItemsMap.get(key).getPrice(),DELTA);
				assertEquals(value.getSpecialPrice(),testItemsMap.get(key).getSpecialPrice(),DELTA);
				assertEquals(value.getUnit(),testItemsMap.get(key).getUnit());
				checkingNumber++;
			}

		}
		assertEquals(4,checkingNumber);
		
	}
}
