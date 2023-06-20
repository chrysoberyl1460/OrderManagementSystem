package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import exception.PhoneFormatException;
import manager.OrderManager;
import order.DomesticOrder;
import order.OrderInput;
import order.OrderKind;

public class OrderAdderListener implements ActionListener {

	JTextField fieldName;
	JTextField fieldPhone;
	JTextField fieldAddress;
	JTextField fieldProduct;
	
	OrderManager orderManager;
	
	public OrderAdderListener(
			JTextField fieldName, 
			JTextField fieldPhone, 
			JTextField fieldAddress,
			JTextField fieldProduct, OrderManager orderManager) {
		
		this.fieldName = fieldName;
		this.fieldPhone = fieldPhone;
		this.fieldAddress = fieldAddress;
		this.fieldProduct = fieldProduct;
		this.orderManager = orderManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		OrderInput order = new DomesticOrder(OrderKind.Domestic);
		try {
			order.setName(fieldName.getText());
			order.setPhone(fieldPhone.getText());
			order.setAddress(fieldAddress.getText());
			order.setProduct(fieldProduct.getText());
			orderManager.addOrder(order);
			putObject(orderManager, "ordermanager.ser");
			order.printInfo();
		} catch (PhoneFormatException e1) {
			e1.printStackTrace();
		}
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
