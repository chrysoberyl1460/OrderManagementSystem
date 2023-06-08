package gui;

import javax.swing.*;

public class OrderAdder extends JPanel{
	
	WindowFrame frame;
	
	public OrderAdder(WindowFrame frame) {
		this.frame = frame;
		
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
		panel.add(labelProduct);
		panel.add(fieldProduct);
		
		panel.add(new JButton("save"));
		panel.add(new JButton("cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6 ,6, 6);
		
		this.add(panel);
		this.setVisible(true);
	}
}
