package controller;

import java.awt.EventQueue;

import view.View;

public class Controller {
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View frame = new View();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();//test only
					}
				}
			});
		}
		
		
		
		
		
		
}	
