import java.util.*;

import order.CrossBorderOrder;
import order.DomesticOrder;
import order.Order;
import order.OrderInput;
import order.OrderKind;

public class OrderManager {
	ArrayList<OrderInput> orders = new ArrayList<OrderInput>();
	Scanner input; 
	OrderManager(Scanner input){
		this.input = input;
	}
	
	
	public void addOrder() {
		
		int kind = 0;
		OrderInput orderInput;
		while (kind != 1 && kind != 2) {
			System.out.println("1. Domestic");
			System.out.println("2. Cross-Border");
			System.out.println("Select num for Order Kind : ");
			kind = input.nextInt();
			if(kind == 1) {
				orderInput = new DomesticOrder(OrderKind.Domestic);
				orderInput.getUserInput(input);
				orders.add(orderInput);
				break;
			}
			else if(kind == 2) {
				orderInput = new CrossBorderOrder(OrderKind.CrossBorder);
				orderInput.getUserInput(input);
				orders.add(orderInput);
				break;
			}
			else
				System.out.print("Select num for Order Kind between 1 and 2 :");
		}	
	}
	
	public void deleteOrder() {
		
		System.out.print("Name : ");
		String checkName = input.next();
		System.out.print("Phone Number : ");
		String checkPhone = input.next();
		
		int index = -1;
		
		for(int i = 0 ; i< orders.size(); i++) {
			if(orders.get(i).getName().equals(checkName) && orders.get(i).getPhone().equals(checkPhone)) {
				index = i;
				break;
			}
		}
		
		if(index >= 0) {
			orders.remove(index);
			System.out.println("Order Cancellation Complete.");
		}
		else {
			System.out.println("Order history is missing or the information is invalid.");
			return ;
		}
	}
	
	public void editOrder() {
		System.out.print("Name : ");
		String checkName = input.next();
		System.out.print("Phone Number : ");
		String checkPhone = input.next();
		
		for(int i = 0 ; i< orders.size(); i++) {
			OrderInput orderInput = orders.get(i);
			if(orderInput.getName().equals(checkName) && orderInput.getPhone().equals(checkPhone)) {
				
				System.out.println("Choose What to Change.");
				System.out.println("=================================");
				System.out.println("1. Address");
				System.out.println("2. Product Order Name");
				System.out.println("3. Address and Product Order Name");
				System.out.println("=================================");
				
				int numEdit = input.nextInt();
				
				if(numEdit == 1) {
					System.out.print("Address : ");
					String address = input.next();
					orderInput.setAddress(address);
				}
				else if(numEdit == 2) {
					System.out.print("Product Order Name : ");
					String product = input.next();
					orderInput.setProduct(product);
				}
				else {
					System.out.print("Address : ");
					String address = input.next();
					orderInput.setAddress(address);
					
					System.out.print("Product Order Name : ");
					String product = input.next();
					orderInput.setProduct(product);
				}
				
				System.out.println("Edit Complete.");
			}
			else {
				System.out.println("Order history is missing or the information is invalid.");
				return ;
			}
			break;
		}
	}
	
	public void viewOrders() {
		for(int i = 0; i < orders.size(); i++) {
			orders.get(i).printInfo();
		}
	}
}