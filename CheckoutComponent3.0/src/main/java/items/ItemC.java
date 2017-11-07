package items;

public class ItemC implements Items {
	
	private final double price=30.0;
	private final int unit=4;
	private final double specialPrice=60.0;
	
	
	public double getPrice() {
		return price;
	}

	public double getTotalPrice(int unit) {
		return (unit/this.unit)*specialPrice+(unit%this.unit)*price;
	}

}
