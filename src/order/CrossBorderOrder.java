package order;

import java.util.Scanner;

public class CrossBorderOrder extends Order{
	
	public CrossBorderOrder(OrderKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {
		setOrderName(input);
		setOrderPhone(input);
		setOrderAddress(input);
		setOrderProduct(input);
	}
	
	public void printInfo() {
		getKindString();
	}
}
