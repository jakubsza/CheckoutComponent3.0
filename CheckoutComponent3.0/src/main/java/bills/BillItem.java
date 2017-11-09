package bills;

import helpers.BillHelper;

public class BillItem {
	
	private String name;
	private int unit;
	
	public BillItem(){
		
	}
	
	public BillItem(String name, int unit){
		this.name=name;
		this.unit=unit;
	}
	
	public String getName(){
		return name;
	}
	
	public int getUnit(){
		return unit;
	}
	
	public void addUnit(int unit){
		this.unit+=unit;
	}
	
	public void setUnit(String unit){
		try{
			int help=Integer.parseInt(unit);
			if(help<=0){
				this.unit=0;
				BillHelper.wrongItemUnitExist=true;
			}
			else{
				this.unit=help;
			}
		}catch(NumberFormatException e){
			this.unit=0;
			BillHelper.wrongItemUnitExist=true;
		}
	}
	
	public void setName(String name){
		this.name=name;
	}
	

}
