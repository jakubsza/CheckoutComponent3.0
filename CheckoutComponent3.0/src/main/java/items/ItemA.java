package items;

public class ItemA implements Items {
	
	private final double price=40.0;
	private final int unit=3;
	private final double specialPrice=70.0;
	
	
	public double getPrice() {
		return price;
	}

	public double getTotalPrice(int unit) {
		return (unit/this.unit)*specialPrice+(unit%this.unit)*price;
	}

}
