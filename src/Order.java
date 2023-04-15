
public class Order {
	
	String name = "Empty";
	String phone = "Empty";
	String address = "Empty";
	String product = "No Order";
	
	public Order() {
	}

	public Order(String name, String phone, String address, String product) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.product = product;
	}
	
	public void viewOrders() {
		System.out.println("Name : " + name + ", Phone Number : " + phone + ", Address : " + address + ", Product Order Name : " + product);
	}
}
