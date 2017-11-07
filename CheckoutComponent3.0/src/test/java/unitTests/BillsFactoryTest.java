package unitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.BillsFactory;

public class BillsFactoryTest {

	String bill;
	
	@Before
	public void setBill(){
		BillsFactory billsFactory = new BillsFactory();
		bill = billsFactory.getBill("B", 2);
	}
	
	@Test
	public void getBillWithOneItem(){
		assertEquals("15.0",bill.substring(bill.length()-4));
	}
	
	@Test
	public void getBillWithWrongItem(){
		assertEquals("Wrong item(s) name(s). You didn't receive bill.",new BillsFactory().getBill("c", 156));
	}
	
}
