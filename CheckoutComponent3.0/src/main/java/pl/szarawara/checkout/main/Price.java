package pl.szarawara.checkout.main;

import java.util.List;

import pl.szarawara.checkout.bills.BillItem;

public interface Price {

	public String getBill(List<BillItem> inputItems);
}
