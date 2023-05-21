package order;

import java.util.Scanner;

import exception.PhoneFormatException;

public abstract class Order implements OrderInput {
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

	public void setPhone(String phone) throws PhoneFormatException{
		if(!phone.contains("-") && !phone.equals("")) {
			throw new PhoneFormatException();
		}
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
	 
	public abstract void printInfo();
	
	public void setOrderName(Scanner input) {
		System.out.print("Name : ");
		String name = input.next();
		this.setName(name);
	}
	
	public void setOrderPhone(Scanner input) {
		String phone = "";
		while (!phone.contains("-")) {
			System.out.print("Phone Number : ");
			phone = input.next();
			try {
				this.setPhone(phone);
			} catch(PhoneFormatException e) {
				System.out.println("Incorrect Phone Format put the phone format that contains '-' ");
			}
		}
	}
	
	public void setOrderAddress(Scanner input) {
		System.out.print("Address : ");
		String address = input.next();
		this.setAddress(address);
	}
	
	public void setOrderProduct(Scanner input) {
		System.out.print("Product Order Name : ");
		String product = input.next();
		this.setProduct(product);
	}
	
	public String getKindString() {
		String skind = "none";
		switch(this.kind) {
		case Domestic:
			skind = "Domestic";
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : " + phone + ", Address : " + address + ", Product Order Name : " + product);
			break;
		case CrossBorder:
			skind = "CrossBorder";
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : +82 10" + phone.substring(3) + ", Address : Korea, Republic of " + address + ", Product Order Name : " + product);
			break;
		default:
			System.out.println("kind : " + skind + " Name : " + name + ", Phone Number : " + phone + ", Address : " + address + ", Product Order Name : " + product);
		}
		return skind;
	}
}
