package controller;

import java.awt.EventQueue;

import javax.naming.NamingException;

import views.Gui;

public class Main {
		
	public static void main(String[] args) throws NamingException {
				
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	  }

}
