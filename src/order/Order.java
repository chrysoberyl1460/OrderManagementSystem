package order;

import java.util.Scanner;

public class Order {
	protected OrderKind kind = OrderKind.Domestic;
	protected String name = "Empty";
	protected String phone = "Empty";
	protected String address = "Empty";
	protected String product = "No Order";
	
	public Order() {
	}
	
	public Order(OrderKind kind) {
		this.kind = kind;
	}
	
	public Order(String name, String phone, String address, String product) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.product = product;
	}

	public Order(OrderKind kind, String name, String phone, String address, String product) {
		this.kind= kind;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.product = product;
	}
	
	public OrderKind getKind() {
		return kind;
	}

	public void setKind(OrderKind kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	 
	public void viewOrders() {
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
}
