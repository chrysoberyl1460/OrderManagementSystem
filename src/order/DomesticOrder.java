package order;

import java.util.Scanner;

public class DomesticOrder extends Order implements OrderInput{
	
	public DomesticOrder(OrderKind kind) {
		super(kind);
	}
	
	public void getUserInput(Scanner input) {

		System.out.print("Name : ");
		String name = input.next();
		this.setName(name);
		
		System.out.print("Phone Number : ");
		String phone = input.next();
		this.setPhone(phone);
		
		System.out.print("Address : ");	
		String address = input.next();
		this.setAddress(address);
		
		System.out.print("Product Order Name : ");
		String product = input.next();
		this.setProduct(product);
	}
	
	public void printInfo() {
		String skind = "none";
		switch(this.kind) {
		case Domestic:
			skind = "Domestic";
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : " + phone + ", Address : " + address + ", Product Order Name : " + product);
			break;
		case CrossBorder:
			skind = "CrossBorder";
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : +82 10" + phone.substring(3) + ", Address : " + address + ", Product Order Name : " + product);
			break;
		default:
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : " + phone + ", Address : " + address + ", Product Order Name : " + product);
		}
	}
}
