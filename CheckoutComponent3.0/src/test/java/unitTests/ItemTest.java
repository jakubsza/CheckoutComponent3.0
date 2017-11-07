package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import bills.Item;
import exceptions.WrongItemNameException;

public class ItemTest {

	@Test
	public void getPriceWithA() throws WrongItemNameException{
		Item item = new Item("A",2);
		
		assertEquals(80.0,item.getPrice(),0);
	}

	@Test
	public void getPriceWithWrongProductName(){
		Item item = new Item("something",25);
		try {
			item.getPrice();
		} catch (WrongItemNameException e) {
			assertEquals("Wrong item(s) name(s).", e.WrongItemNameExceptionMethod());
		}
	}
}
