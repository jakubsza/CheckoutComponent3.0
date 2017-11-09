package helpers;

import java.util.List;

import bills.BillItem;
import items.Item;

public class BillHelper {

	private static final String wrongItemNameAndUnitAnswer = "Found wrong item(s) name(s) and units. Bill calculated for correct. ";
	private static final String wrongItemNameAnswer = "Found wrong item(s) name(s). Bill calculated for correct. ";
	private static final String wrongItemUnitAnswer = "Found wrong item(s) units. Bill calculated for correct. ";
	private static final String billValueAnswerPrefix = "You have to pay: ";
	public static final String billValueAnswerSufix = " PLN for your item(s).";
	private static boolean wrongItemNameExist=false;
	public static boolean wrongItemUnitExist=false;
	
	public static List<BillItem> updateItems(List<BillItem> inputItems){
		inputItems = sumUpDuplicatedItems(inputItems);
		inputItems = removingItemsWithNonUnits(inputItems);
		return inputItems;
	}
	
	private static List<BillItem> sumUpDuplicatedItems(List<BillItem> inputItems){
		for(int i=0; i<inputItems.size()-1;i++){
			String name=inputItems.get(i).getName();
			for(int j=i+1; j<inputItems.size();j++){
				if((inputItems.get(j).getName()).equals(name)){
					inputItems.get(i).addUnit(inputItems.get(j).getUnit());
					inputItems.get(j).addUnit(-inputItems.get(j).getUnit());
				}
			}
		}
		return inputItems;
	}
	
	private static List<BillItem> removingItemsWithNonUnits(List<BillItem> inputItems){
		for(int i=0; i<inputItems.size();i++){
			if(inputItems.get(i).getUnit()==0){
				inputItems.remove(inputItems.get(i));
			}
		}
		return inputItems;
	}
	
	public static double getBillValue(List<BillItem> inputItems, List<Item> itemList){
		double totalBill=0;
		for(int i=0; i<inputItems.size();i++){
			String name=inputItems.get(i).getName();
			boolean foundItem=false;
			for(int j=0; j<itemList.size();j++){
				if((itemList.get(j).getName()).equals(name)){
					totalBill+=itemList.get(j).getTotalPrice(inputItems.get(i).getUnit());
					foundItem=true;
				}
				else if(!foundItem && j==itemList.size()-1){
					wrongItemNameExist=true;
				}
			}
		}
		return totalBill;
	}
	
	public static String checkingAnswer(){
		
		String answer="";

		if(wrongItemNameExist && wrongItemUnitExist){
			answer=wrongItemNameAndUnitAnswer;
		}
		else if(wrongItemNameExist){
			answer=wrongItemNameAnswer;
		}
		else if(wrongItemUnitExist){
			answer=wrongItemUnitAnswer;
		}
		answer+=billValueAnswerPrefix;
		
		return answer;
	}
	
	public static void cleanValues(){
		wrongItemNameExist=false;
		wrongItemUnitExist=false;
	}
	
}
