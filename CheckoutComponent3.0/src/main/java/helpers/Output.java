package helpers;

import org.springframework.web.bind.annotation.PathVariable;

public class Output {
	
	private static String getHurdle(){
		String hurdle="";
		for (int i=0; i<20;i++){
			hurdle+="=";
		}
		return hurdle;
	}
	
	public static String createSingleBill(String par1, int unit1, double price){
		String bill="";
		bill = par1+Html.fakeTab(10)+"x"+unit1+Html.fakeTab(5)+price+Html.newLine();
		return bill;
	}
	
	public static String createTotalBill(double price){
		String bill="";
		bill = bill+Output.getHurdle();
		bill = bill+Html.newLine()+"Total price"+Html.fakeTab(10)+price;
		return bill;
	}
}
