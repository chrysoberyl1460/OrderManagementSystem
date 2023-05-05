import java.util.*;

import order.CrossBorderOrder;
import order.Order;
import order.OrderKind;

public class OrderManager {
	ArrayList<Order> orders = new ArrayList<Order>();
	Scanner input; 
	OrderManager(Scanner input){
		this.input = input;
	}
	
	
	public void addOrder() {
		
		int kind = 0;
		Order order;
		while (kind != 1 && kind != 2) {
			System.out.println("1. Domestic");
			System.out.println("2. Cross-Border");
			System.out.println("Select num for Order Kind : ");
			kind = input.nextInt();
			if(kind == 1) {
				order = new Order(OrderKind.Domestic);
				order.getUserInput(input);
				orders.add(order);
				break;
			}
			else if(kind == 2) {
				order = new CrossBorderOrder(OrderKind.CrossBorder);
				order.getUserInput(input);
				orders.add(order);
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
			Order order = orders.get(i);
			if(order.getName().equals(checkName) && order.getPhone().equals(checkPhone)) {
				
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
					order.setAddress(address);
				}
				else if(numEdit == 2) {
					System.out.print("Product Order Name : ");
					String product = input.next();
					order.setProduct(product);
				}
				else {
					System.out.print("Address : ");
					String address = input.next();
					order.setAddress(address);
					
					System.out.print("Product Order Name : ");
					String product = input.next();
					order.setProduct(product);
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