import java.util.*;

public class MenuManager {
	public static void main(String[] args) {
		
		int num = 0;
		Scanner input = new Scanner(System.in);
		OrderManager orderManager = new OrderManager(input);
		
		while(num != 5) {
			
			System.out.println();
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Edit Order");
			System.out.println("4. View Orders");
			System.out.println("5. Exit");
			System.out.println("Select one number between 1-5.");
			
			num = input.nextInt();
			
			if(num == 1) {
				orderManager.addOrder();
			}
			else if(num == 2) {
				orderManager.deleteOrder();
			}
			else if(num == 3) {
				orderManager.editOrder();
			}
			else if(num == 4) {
				orderManager.viewOrders();
			}
		}
	}
}
