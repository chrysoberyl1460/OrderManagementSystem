package order;

import java.util.Scanner;

public abstract class Order {
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
	 
	public abstract void printInfo();
}
