import java.util.*;

public class OrderManager {
	ArrayList<Order> orders = new ArrayList<Order>();
	Scanner input; 
	OrderManager(Scanner input){
		this.input = input;
	}
	
	
	public void addOrder() {
		Order order = new Order();
		
		System.out.print("Name : ");
		order.name = input.next();
		
		System.out.print("Phone Number : ");
		order.phone = input.next();
		
		System.out.print("Address : ");	
		order.address = input.next();
		
		System.out.print("Product Order Name : ");
		order.product = input.next();
		
		orders.add(order);
		
	}
	
	public void deleteOrder() {
		
		System.out.print("Name : ");
		String checkName = input.next();
		System.out.print("Phone Number : ");
		String checkPhone = input.next();
		
		int index = -1;
		
		for(int i = 0 ; i< orders.size(); i++) {
			if(orders.get(i).name.equals(checkName) && orders.get(i).phone.equals(checkPhone)) {
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
			if(order.name.equals(checkName) && order.phone.equals(checkPhone)) {
				
				System.out.println("Choose What to Change.");
				System.out.println("=================================");
				System.out.println("1. Address");
				System.out.println("2. Product Order Name");
				System.out.println("3. Address and Product Order Name");
				System.out.println("=================================");
				
				int numEdit = input.nextInt();
				
				if(numEdit == 1) {
					System.out.print("Address : ");
					order.address = input.next();;
				}
				else if(numEdit == 2) {
					System.out.print("Product Order Name : ");
					order.product = input.next();
				}
				else {
					System.out.print("Address : ");
					order.address = input.next();
					
					System.out.print("Product Order Name : ");
					order.product = input.next();
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
			orders.get(i).viewOrders();
		}
		
	}
}