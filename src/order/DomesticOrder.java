package order;

import java.util.Scanner;

public class DomesticOrder extends Order{
	
	public DomesticOrder(OrderKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setOrderName(input);
		setOrderPhone(input);
		setOrderAddress(input);
		setOrderProduct(input);
	}
	
	public void printInfo() {
		String skind = getKindString();
	}
}
