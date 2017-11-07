package bills;

import exceptions.WrongItemNameException;
import items.ItemA;
import items.ItemB;
import items.ItemC;
import items.ItemD;

public class Item {
	
	private String par;
	private int unit;
	
	public Item(String par, int unit){
		this.par=par;
		this.unit=unit;
	}
	
	public double getPrice() throws WrongItemNameException{
		if(par.equals("A")){
			return new ItemA().getTotalPrice(unit);
		}
		else if(par.equals("B")){
			return new ItemB().getTotalPrice(unit);
		}
		else if(par.equals("C")){
			return new ItemC().getTotalPrice(unit);
		}
		else if(par.equals("D")){
			return new ItemD().getTotalPrice(unit);
		}
		throw new WrongItemNameException();
	}

}
