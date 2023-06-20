package order;

import java.util.Scanner;
import exception.PhoneFormatException;

public interface OrderInput {
	
	public String getName();
	
	public void setName(String name);
	
	public String getPhone();
	
	public void setPhone(String phone) throws PhoneFormatException;
	
	public String getAddress();
	
	public void setAddress(String address);
	
	public String getProduct();
	
	public void setProduct(String product);
	
	public void getUserInput(Scanner input);
	
	public void printInfo();
	
	public void setOrderName(Scanner input);
	
	public void setOrderPhone(Scanner input);
	
	public void setOrderAddress(Scanner input);
	
	public void setOrderProduct(Scanner input);
	
}
