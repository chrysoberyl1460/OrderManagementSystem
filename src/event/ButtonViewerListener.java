package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.JButton;

import gui.OrderViewer;
import gui.WindowFrame;
import manager.OrderManager;

public class ButtonViewerListener implements ActionListener {
	
	WindowFrame frame;
	
	public ButtonViewerListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OrderViewer orderViewer = frame.getOrderviewer();
		OrderManager orderManager = getObject("ordermanager.ser");
		orderViewer.setOrderManager(orderManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(orderViewer);
		frame.revalidate();
		frame.repaint();
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
}
