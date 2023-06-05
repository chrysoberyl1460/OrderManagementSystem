package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrderViewer extends JFrame{
	public OrderViewer() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Phone Number");
		model.addColumn("Address");
		model.addColumn("Product");
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
