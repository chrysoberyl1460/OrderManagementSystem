import java.util.*;

public class MenuManager {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		OrderManager orderManager = new OrderManager(input); 
		selectMenu(input, orderManager);
	}
	public static void selectMenu(Scanner input, OrderManager orderManager) {
		int num = -1;
		while(num != 5) {
			try {
				showMenu();
				num = input.nextInt();
				switch(num) {
				case 1:
					orderManager.addOrder();
					break;
				case 2:
					orderManager.deleteOrder();
					break;
				case 3:
					orderManager.editOrder();
					break;
				case 4:
					orderManager.viewOrders();
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 5!");
				if(input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}
	
	public static void showMenu() {
		System.out.println();
		System.out.println("1. Add Order");
		System.out.println("2. Delete Order");
		System.out.println("3. Edit Order");
		System.out.println("4. View Orders");
		System.out.println("5. Exit");
		System.out.println("Select one number between 1-5.");
	}
}
