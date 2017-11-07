package items;

public class ItemD implements Items {
	
	private final double price=25.0;
	private final int unit=2;
	private final double specialPrice=40.0;
	
	
	public double getPrice() {
		return price;
	}

	public double getTotalPrice(int unit) {
		return (unit/this.unit)*specialPrice+(unit%this.unit)*price;
	}

}
