package main;

import org.springframework.web.servlet.ModelAndView;

public interface Price {

	public String getBill(String par1, String par2, String par3, String par4, int unit1, int unit2, int unit3, int unit4);

	public String getBill(String par1, String par2, String par3, int unit1, int unit2, int unit3);
	
	public String getBill(String par1, String par2,int unit1, int unit2);
	
	public String getBill(String par1, int unit1);
}
