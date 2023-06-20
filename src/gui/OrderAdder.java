package gui;

import javax.swing.*;

import event.OrderAdderCancelListener;
import event.OrderAdderListener;
import manager.OrderManager;

public class OrderAdder extends JPanel{
	
	WindowFrame frame;
	OrderManager orderManager;
	
	public OrderAdder(WindowFrame frame, OrderManager orderManager) {
		this.frame = frame;
		this.orderManager = orderManager;
		
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelName = new JLabel("Name : ", JLabel.TRAILING);
		JTextField fieldName = new JTextField(10);
		labelName.setLabelFor(fieldName);
		panel.add(labelName);
		panel.add(fieldName);
		
		JLabel labelPhone = new JLabel("Phone Number : ", JLabel.TRAILING);
		JTextField fieldPhone = new JTextField(10);
		labelPhone.setLabelFor(fieldPhone);
		panel.add(labelPhone);
		panel.add(fieldPhone);
		
		JLabel labelAddress = new JLabel("Address : ", JLabel.TRAILING);
		JTextField fieldAddress = new JTextField(10);
		labelAddress.setLabelFor(fieldAddress);
		panel.add(labelAddress);
		panel.add(fieldAddress);
		
		JLabel labelProduct = new JLabel("Product : ", JLabel.TRAILING);
		JTextField fieldProduct = new JTextField(10);
		labelProduct.setLabelFor(fieldProduct);
		
		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new OrderAdderListener(fieldName, fieldPhone, fieldAddress, fieldProduct, orderManager));
		JButton cancelButton = new JButton("cancel");
		cancelButton.addActionListener(new OrderAdderCancelListener(frame));
		
		panel.add(labelProduct);
		panel.add(fieldProduct);
		
		panel.add(saveButton);
		panel.add(cancelButton);
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6 ,6, 6);
		
		this.add(panel);
		this.setVisible(true);
	}
}
