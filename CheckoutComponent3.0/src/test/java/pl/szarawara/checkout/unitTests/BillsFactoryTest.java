package pl.szarawara.checkout.unitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pl.szarawara.checkout.bills.BillItem;
import pl.szarawara.checkout.main.BillsFactory;

public class BillsFactoryTest {

	BillsFactory billsFactory;

	@Before
	public void setBill() {
		billsFactory = new BillsFactory();
	}

	@Test
	public void getBillWithWrongItemName() {
		List<BillItem> inputItems = new ArrayList<BillItem>();
		BillItem item = new BillItem();
		item.setName("wrongName");
		item.setUnit("1");
		inputItems.add(item);
		assertEquals("Found wrong item(s) name(s). Bill calculated for correct. You have to pay: 0.0 PLN for your item(s).", billsFactory.getBill(inputItems));
	}
	
	@Test
	public void getBillWithWrongItemUnit() {
		List<BillItem> inputItems = new ArrayList<BillItem>();
		BillItem item = new BillItem();
		item.setName("A");
		item.setUnit("wrongUnit");
		inputItems.add(item);
		assertEquals("Found wrong item(s) units. Bill calculated for correct. You have to pay: 0.0 PLN for your item(s).", billsFactory.getBill(inputItems));
	}

	@Test
	public void getBillWithNullItem() {
		List<BillItem> inputItems = new ArrayList<BillItem>();
		inputItems.add(new BillItem());
		assertEquals("Found wrong item(s) units. Bill calculated for correct. You have to pay: 0.0 PLN for your item(s).", billsFactory.getBill(inputItems));
	}

}
