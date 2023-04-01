import java.util.*;

public class MenuManager {
	public static void main(String[] args) {
		int num = 0;
		Scanner input = new Scanner(System.in);
		
		String product = "No Order";
		String address = "Empty";
		String name = "Empty";
		String phone = "Empty";
		
		while(num != 6) {
			
			System.out.println();
			System.out.println("1. Add Orders");
			System.out.println("2. Delete Orders");
			System.out.println("3. Edit Orders");
			System.out.println("4. View Orders");
			System.out.println("5. Show a Menu");
			System.out.println("6. Exit");
			System.out.println("Select one number between 1-6.");
			
			num = input.nextInt();
			
			if(num == 1) {
				String arr1[] = Arrays.copyOf(addOrders(), 4);
				
				name = arr1[0];
				phone = arr1[1];
				address = arr1[2];
				product = arr1[3];
			}
			else if(num == 2) {
				product = deleteOrders(name, phone, product);
			}
			else if(num == 3) {
				String arr3[] = Arrays.copyOf(editOrders(), 2);
				if(arr3[0] != null)
					address = arr3[0];
				if(arr3[1] != null)
					product = arr3[1];
			}
			else if(num == 4) {
				viewOrders(name, phone, address, product);
			}
		}
	}
	
	public static String[] addOrders() {
		Scanner input = new Scanner(System.in);
		System.out.print("Name : ");
		String name = input.next();
		
		System.out.print("Phone Number : ");
		String phone = input.next();
		
		System.out.print("Address : ");
		String address = input.next();
		
		System.out.print("Product Order Name : ");
		String product = input.next();
		
		String arr[] = new String[4];
		arr[0] = name;
		arr[1] = phone;
		arr[2] = address;
		arr[3] = product;
		
		return arr;
		
	}
	
	public static String deleteOrders(String name, String phone, String product) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Name : ");
		String checkName = input.next();
		System.out.print("Phone Number : ");
		String checkPhone = input.next();

		if((name.equals(checkName)) && (phone.equals(checkPhone)) && (product != "No Order")) {
			product = "No Order";
			System.out.println("Order Cancellation Complete.");
			System.out.println("Product : " + product);
		}
		else 
			System.out.println("Order history is missing or the information is invalid.");
		
		return product;
	}
	
	public static String[] editOrders() {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose What to Change.");
		System.out.println("=================================");
		System.out.println("1. Address");
		System.out.println("2. Product Order Name");
		System.out.println("3. Address and Product Order Name");
		System.out.println("=================================");
		
		int numEdit = input.nextInt();
		

		String arr[] = new String[2];
		
		if(numEdit == 1) {
			System.out.print("Address : ");
			String address = input.next();
			arr[0] = address;
		}
		else if(numEdit == 2) {
			System.out.print("Product Order Name : ");
			String product = input.next();
			arr[1] = product;
		}
		else {
			System.out.print("Address : ");
			String address1 = input.next();
			arr[0] = address1;
			
			System.out.print("Product Order Name : ");
			String product1 = input.next();
			arr[1] = product1;
		}
		
		System.out.print("Edit Complete.");
		
		return arr;
	}
	
	public static void viewOrders(String name, String phone, String address, String product) {
		System.out.println("Name : " + name);
		System.out.println("Phone Number : " + phone);
		System.out.println("Address : " + address);
		System.out.println("Product Order Name : " + product);
	}
}
