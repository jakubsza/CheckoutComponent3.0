package items;

public class ItemB implements Items {
	
	private final double price=10.0;
	private final int unit=2;
	private final double specialPrice=15.0;
	
	
	public double getPrice() {
		return price;
	}

	public double getTotalPrice(int unit) {
		return (unit/this.unit)*specialPrice+(unit%this.unit)*price;
	}

}
