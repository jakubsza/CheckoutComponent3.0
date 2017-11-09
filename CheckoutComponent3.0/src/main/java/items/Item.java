package items;

public class Item implements Items {

	private String name;
	private double price;
	private int unit;
	private double specialPrice;

	public Item(String name, double price, int unit, double specialPrice) {
		this.name=name;
		this.price = price;
		this.unit = unit;
		this.specialPrice = specialPrice;
	}

	public String getName() {
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getSpecialPrice(){
		return specialPrice;
	}
	
	public int getUnit(){
		return unit;
	}
	

	public double getTotalPrice(int unit) {
		return (unit / this.unit) * specialPrice + (unit % this.unit) * price;
	}

}
