package pl.szarawara.checkout.main;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import pl.szarawara.checkout.bills.BillItem;
import pl.szarawara.checkout.helpers.BillHelper;


@Path("/checkout")
public class BillsFactory implements Price{

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getBill(List<BillItem> inputItems){
		BillHelper billHelper = new BillHelper(inputItems);
		return billHelper.getBill();
	}
}
