package helpers;

import bills.Item;
import exceptions.WrongItemNameException;

public class CreatingLines {

	public static void createLine(String par1, int unit1, BillHelper billHelper){
		try{
			Item item = new Item(par1,unit1);
			double price = item.getPrice();
			String bill=Output.createSingleBill(par1, unit1, price);

			billHelper.addTotalBill(price);
			billHelper.addOutputLine(bill);
		}
		catch(WrongItemNameException wine){
			billHelper.setWrongItemNameLine(true);
		}
	}
	
	public static String createTotalLine(BillHelper billHelper){
		String line="";
		if(billHelper.isWrongItemNameLine()){
			if(billHelper.getTotalBill()==0){
				line=billHelper.getOutputLine();
				line+=billHelper.getWrongAllItemsNameLine();
			}
			else{
				line=billHelper.getWrongSomeItemsNameLine()+Html.newLine();
				line+=billHelper.getOutputLine();
				line+=Output.createTotalBill(billHelper.getTotalBill());
			}
		}
		else{
			line=billHelper.getOutputLine();
			line+=Output.createTotalBill(billHelper.getTotalBill());
			}

		return line;
	}
}
