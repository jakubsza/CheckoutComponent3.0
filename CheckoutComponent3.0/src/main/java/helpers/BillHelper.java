package helpers;

public class BillHelper {

	private double totalBill=0.0;
	private String outputLine="";
	private boolean wrongItemNameLine=false;
	private final String wrongAllItemsNameLine="Wrong item(s) name(s). You didn't receive bill.";
	private final String wrongSomeItemsNameLine="Some items had got wrong names. We provided bill with correct items.";

	public void addTotalBill(double totalBill){
		this.totalBill+=totalBill;
	}
	
	public void addOutputLine(String outputLine){
		this.outputLine+=outputLine;
	}
	
	public double getTotalBill(){
		return totalBill;
	}
	
	public String getOutputLine(){
		return outputLine;
	}
	
	public void setWrongItemNameLine(boolean wrongItemNameLine){
		this.wrongItemNameLine=wrongItemNameLine;
	}
	
	public boolean isWrongItemNameLine(){
		return wrongItemNameLine;
	}
	
	public String getWrongAllItemsNameLine(){
		return wrongAllItemsNameLine;
	}
	
	public String getWrongSomeItemsNameLine(){
		return wrongSomeItemsNameLine;
	}
}
