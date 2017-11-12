package pl.szarawara.checkout.helpers;

public class ItemsHelper {

	public static String[] getValues(String line){
		String[] result = line.split(";");
		return result;
	}
	
	
}
