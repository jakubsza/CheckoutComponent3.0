package pl.szarawara.checkout.helpers;

import java.util.List;
import java.util.Map;

import pl.szarawara.checkout.bills.BillItem;
import pl.szarawara.checkout.items.Item;
import pl.szarawara.checkout.items.ItemMainSingleton;

public class BillHelper {

	private final String wrongItemNameAndUnitAnswer = "Found wrong item(s) name(s) and units. Bill calculated for correct. ";
	private final String wrongItemNameAnswer = "Found wrong item(s) name(s). Bill calculated for correct. ";
	private final String wrongItemUnitAnswer = "Found wrong item(s) units. Bill calculated for correct. ";
	private final String billValueAnswerPrefix = "You have to pay: ";
	private final String billValueAnswerSufix = " PLN for your item(s).";
	private boolean wrongItemNameExist = false;
	private boolean wrongItemUnitExist = false;
	private List<BillItem> inputItems;
	private Map<String, Item> itemsMap;
	private double totalBill = 0;
	private String answer = "";

	public BillHelper() {
	}

	public BillHelper(List<BillItem> inputItems) {
		this.inputItems = inputItems;
	}

	public String getBill() {
		ItemMainSingleton main = ItemMainSingleton.getinstance();

		this.itemsMap = main.getItemMap();
		checkingIfNamesAreCorrectAndRemovingIncorrect();
		checkingIfUnitsAreCorrectAndRemovingIncorrect();

		updateItems();
		getBillValue();
		creatingAnswer();

		return answer;

	}

	private void checkingIfNamesAreCorrectAndRemovingIncorrect() {
		int i = 0;
		while (i < inputItems.size()) {
			if (inputItems.get(i).getUnit() == 0) {
				wrongItemUnitExist = true;
				inputItems.remove(inputItems.get(i));
			}
			i++;
		}

	}

	private void checkingIfUnitsAreCorrectAndRemovingIncorrect() {
		int i = 0;
		while (i < inputItems.size()) {
			if (!(itemsMap.containsKey(inputItems.get(i).getName()))) {
				wrongItemNameExist = true;
				inputItems.remove(inputItems.get(i));
			}
			i++;
		}

	}

	private void updateItems() {
		sumUpDuplicatedItems();
		removingItemsWithZeroUnits();
	}

	private void sumUpDuplicatedItems() {
		for (int i = 0; i < inputItems.size() - 1; i++) {
			String name = inputItems.get(i).getName();
			for (int j = i + 1; j < inputItems.size(); j++) {
				if ((inputItems.get(j).getName()).equals(name)) {
					inputItems.get(i).addUnit(inputItems.get(j).getUnit());
					inputItems.get(j).setUnit("0");
				}
			}
		}
	}

	private void removingItemsWithZeroUnits() {
		for (int i = 0; i < inputItems.size(); i++) {
			if (inputItems.get(i).getUnit() == 0) {
				inputItems.remove(inputItems.get(i));
			}
		}
	}

	private double getBillValue() {
		for (int i = 0; i < inputItems.size(); i++) {
			String itemName = inputItems.get(i).getName();
			if (itemsMap.containsKey(itemName)) {
				int unitsValue = inputItems.get(i).getUnit();
				totalBill += itemsMap.get(itemName).getTotalPrice(unitsValue);
			}
		}
		return totalBill;
	}

	private String creatingAnswer() {
		if (wrongItemNameExist && wrongItemUnitExist) {
			answer = wrongItemNameAndUnitAnswer;
		} else if (wrongItemNameExist) {
			answer = wrongItemNameAnswer;
		} else if (wrongItemUnitExist) {
			answer = wrongItemUnitAnswer;
		}
		answer += billValueAnswerPrefix;

		answer += Double.toString(totalBill) + billValueAnswerSufix;

		return answer;
	}

}
