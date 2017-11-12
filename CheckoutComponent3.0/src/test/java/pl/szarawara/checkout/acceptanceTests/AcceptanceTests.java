package pl.szarawara.checkout.acceptanceTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pl.szarawara.checkout.bills.BillItem;
import pl.szarawara.checkout.main.BillsFactory;

public class AcceptanceTests {

	private BillsFactory billsFactory;
	private String bill;
	List<BillItem> inputItems;

	@Given("checkout")
	public void input1() {
		billsFactory = new BillsFactory();
	}

	@When("item B and unit 2")
	public void input2() {
		inputItems = new ArrayList<BillItem>();
		BillItem item = new BillItem();
		item.setName("B");
		item.setUnit("2");
		inputItems.add(item);
	}

	@Then("result should be 15")
	public void result() {
		bill = billsFactory.getBill(inputItems);
		assertEquals("You have to pay: 15.0 PLN for your item(s).",bill);
	}
}
