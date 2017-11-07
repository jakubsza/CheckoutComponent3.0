package acceptanceTests;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.BillsFactory;

public class AcceptanceTests {

	private BillsFactory billsFactory;
	private String bill;


	@Given("checkout")
	public void input1() {
		billsFactory = new BillsFactory();
	}

	@When("item B and unit 2")
	public void input2() {
		bill = billsFactory.getBill("B", 2);
	}

	@Then("result should be 15")
	public void result() {
		bill = billsFactory.getBill("B", 2);
		assertEquals("15.0",bill.substring(bill.length()-4));
	}
}
