package pl.szarawara.checkout.items;

public interface Items {

	public double getPrice();
	public double getSpecialPrice();
	public int getUnit();
	public double getTotalPrice(int unit);
}
