package gui;

import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import manager.OrderManager;
import order.OrderInput;

public class OrderViewer extends JPanel{
	
	WindowFrame frame;
	OrderManager orderManager;
	
	public OrderManager getOrderManager() {
		return orderManager;
	}

	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
		this.removeAll();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Phone Number");
		model.addColumn("Address");
		model.addColumn("Product");
		
		for(int i = 0; i < orderManager.size(); i++) {
			Vector row = new Vector();
			OrderInput oi = orderManager.get(i);
			row.add(oi.getName());
			row.add(oi.getPhone());
			row.add(oi.getAddress());
			row.add(oi.getProduct());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}

	public OrderViewer(WindowFrame frame, OrderManager orderManager) {
		this.frame = frame;
		this.orderManager = orderManager;
		
		System.out.println("***" + orderManager.size() + "***");
		 
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Name");
		model.addColumn("Phone Number");
		model.addColumn("Address");
		model.addColumn("Product");
		
		for(int i = 0; i < orderManager.size(); i++) {
			Vector row = new Vector();
			OrderInput oi = orderManager.get(i);
			row.add(oi.getName());
			row.add(oi.getPhone());
			row.add(oi.getAddress());
			row.add(oi.getProduct());
			model.addRow(row);
		}
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}
}
