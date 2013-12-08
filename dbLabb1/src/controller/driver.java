package controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import view.View;

public class driver {
	private ArrayList<String> test;
	private View frame;
		public  void start() {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new View();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();//test only
					}
				}
			});
			getvaluealbum();
		}
		
		public void getvaluealbum(){
			test.add(frame.song.getText);
			
			
			
		}
		
		public void actionlisteneralbum(){
			
		}
}
