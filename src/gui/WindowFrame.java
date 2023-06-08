package gui;

import javax.swing.*;

import manager.OrderManager;

public class WindowFrame extends JFrame{
	
	OrderManager orderManager;
	MenuSelection menuselection;
	OrderAdder orderadder;
	OrderViewer orderviewer;
	
	public WindowFrame(OrderManager orderManager) {
		
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");
		
		this.orderManager = orderManager;
		menuselection = new MenuSelection(this);
		orderadder = new OrderAdder(this);
		orderviewer = new OrderViewer(this, this.orderManager);
		
		this.add(menuselection);
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuselection() {
		return menuselection;
	}

	public void setMenuselection(MenuSelection menuselection) {
		this.menuselection = menuselection;
	}

	public OrderAdder getOrderadder() {
		return orderadder;
	}

	public void setOrderadder(OrderAdder orderadder) {
		this.orderadder = orderadder;
	}

	public OrderViewer getOrderviewer() {
		return orderviewer;
	}

	public void setOrderviewer(OrderViewer orderviewer) {
		this.orderviewer = orderviewer;
	}
}
