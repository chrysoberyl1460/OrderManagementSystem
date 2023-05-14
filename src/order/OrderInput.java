package order;

import java.util.Scanner;

public interface OrderInput {
	
	public String getName();
	
	public void setName(String name);
	
	
	public String getPhone();
	
	public void setPhone(String phone);
	
	
	public void setAddress(String address);
	
	public void setProduct(String product);
	
	public void getUserInput(Scanner input);
	
	public void printInfo();
}
