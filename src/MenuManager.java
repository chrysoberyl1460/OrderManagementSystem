import java.util.Scanner;

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
		
			switch(num) {
			
			case 1:
				System.out.print("Name : ");
				String name1 = input.next();
				name = name1;
				
				System.out.print("Phone Number : ");
				String phone1 = input.next();
				phone = phone1;
				
				System.out.print("Address : ");
				String address1 = input.next();
				address = address1;
				
				System.out.print("Product Order Name : ");
				String product1 = input.next();
				product = product1;
				break;
				
			case 2:
				System.out.print("Name : ");
				String checkName = input.next();
				System.out.print("Phone Number : ");
				String checkPhone = input.next();
		
				if((name.equals(checkName)) && (phone.equals(checkPhone)) && (product != "No Order")) {
					product = "No Order";
					System.out.println("Order Cancellation Complete.");
					System.out.println("Product : " + product);
					break;
				}
				else {
					System.out.println("Order history is missing or the information is invalid.");
					break;
				}
				
			case 3:
				System.out.println("Choose What to Change.");
				System.out.println("=================================");
				System.out.println("1. Address");
				System.out.println("2. Product Order Name");
				System.out.println("3. Address and Product Order Name");
				System.out.println("=================================");
				
				int numEdit = input.nextInt();
				
				switch(numEdit) {
				case 1:
					System.out.print("Address : ");
					String address2 = input.next();
					address = address2;
					break;
				
				case 2:
					System.out.print("Product Order Name : ");
					String product2 = input.next();
					product = product2;
					break;
					
				case 3:
					System.out.print("Address : ");
					String address3 = input.next();
					address = address3;
					
					System.out.print("Product Order Name : ");
					String product3 = input.next();
					product = product3;
					break;
				}
				System.out.print("Edit Complete.");
				break;
				
			case 4:
				System.out.println("Name : " + name);
				System.out.println("Phone Number : " + phone);
				System.out.println("Address : " + address);
				System.out.println("Product Order Name : " + product);
				break;
			}
		}

	}
}
