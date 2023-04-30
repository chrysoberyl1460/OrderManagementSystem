package order;

import java.util.Scanner;

public class CrossBorderOrder extends Order {
	public void getUserInput(Scanner input) {

		System.out.print("Name : ");
		String name = input.next();
		this.setName(name);
		
		System.out.print("Phone Number : ");
		String phone = input.next();
		this.setPhone(phone);
		
		System.out.print("Address : ");	
		String address = input.next();
		address = "Korea Republic of " + address;
		this.setAddress(address);
		
		System.out.print("Product Order Name : ");
		String product = input.next();
		this.setProduct(product);
	}

}
