package main;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import bills.BillItem;
import helpers.BillHelper;
import items.Item;
import items.Main;


@Path("/checkout")
public class BillsFactory implements Price{
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getBill(List<BillItem> inputItems){

		double totalBill=0;
		String answer;
		Main main = new Main();
		main.setUpItems();
		
		List<Item> itemList = main.getItemList();

		inputItems = BillHelper.updateItems(inputItems);
		totalBill = BillHelper.getBillValue(inputItems, itemList);
		answer = BillHelper.checkingAnswer();
		answer+=Double.toString(totalBill)+BillHelper.billValueAnswerSufix;
		
		BillHelper.cleanValues();
		return answer;
	}
}
