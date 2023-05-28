import java.io.*;
import java.util.*;

import log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("Log.txt");
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		OrderManager orderManager = getObject("ordermanager.ser");
		if(orderManager == null) {
			orderManager = new OrderManager(input);
		}
		else
			orderManager.setInput(input);
		selectMenu(input, orderManager);
		putObject(orderManager, "ordermanager.ser");
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
					logger.log("add a order");
					break;
				case 2:
					orderManager.deleteOrder();
					logger.log("delete a order");
					break;
				case 3:
					orderManager.editOrder();
					logger.log("edit a order");
					break;
				case 4:
					orderManager.viewOrders();
					logger.log("edit a list of order");
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
	
	public static OrderManager getObject(String filename) {
	    OrderManager orderManager = null;
	    try {
	        FileInputStream file = new FileInputStream(filename);
	        ObjectInputStream in = new ObjectInputStream(file);
	        orderManager = (OrderManager) in.readObject(); 
	        
	        in.close();
	        file.close();
	        
	    } catch (FileNotFoundException e) {
	        orderManager = new OrderManager(new Scanner(System.in));
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    return orderManager;
	}

	
	public static void putObject(OrderManager orderManager, String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(orderManager); 	
			out.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
