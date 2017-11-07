package main;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import helpers.BillHelper;
import helpers.CreatingLines;

@RestController
public class BillsFactory implements Price{

	@RequestMapping("/checkout/{par1}={unit1}/{par2}={unit2}/{par3}={unit3}/{par4}={unit4}")
	public String getBill(@PathVariable String par1, @PathVariable String par2, @PathVariable String par3, @PathVariable String par4, @PathVariable int unit1, @PathVariable int unit2, @PathVariable int unit3, @PathVariable int unit4) {
		BillHelper billHelper = new BillHelper();
		CreatingLines.createLine(par1, unit1, billHelper);
		CreatingLines.createLine(par2, unit2, billHelper);
		CreatingLines.createLine(par3, unit3, billHelper);
		CreatingLines.createLine(par4, unit4, billHelper);
		return CreatingLines.createTotalLine(billHelper);
	}

	@RequestMapping("/checkout/{par1}={unit1}/{par2}={unit2}/{par3}={unit3}")
	public String getBill(@PathVariable String par1, @PathVariable String par2, @PathVariable String par3, @PathVariable int unit1, @PathVariable int unit2, @PathVariable int unit3) {
		BillHelper billHelper = new BillHelper();
		CreatingLines.createLine(par1, unit1, billHelper);
		CreatingLines.createLine(par2, unit2, billHelper);
		CreatingLines.createLine(par3, unit3, billHelper);
		return CreatingLines.createTotalLine(billHelper);
	}

	@RequestMapping("/checkout/{par1}={unit1}/{par2}={unit2}")
	public String getBill(@PathVariable String par1, @PathVariable String par2, @PathVariable int unit1, @PathVariable int unit2) {
		BillHelper billHelper = new BillHelper();
		CreatingLines.createLine(par1, unit1, billHelper);
		CreatingLines.createLine(par2, unit2, billHelper);
		return CreatingLines.createTotalLine(billHelper);
	}
	
	@RequestMapping("/checkout/{par1}={unit1}")
	public String getBill(@PathVariable String par1, @PathVariable int unit1) {
		BillHelper billHelper = new BillHelper();
		CreatingLines.createLine(par1, unit1, billHelper);
		return CreatingLines.createTotalLine(billHelper);
	}
}
