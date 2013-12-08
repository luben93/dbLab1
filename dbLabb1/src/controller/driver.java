package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import view.View;

public class driver {
	private ArrayList<String> test;
	private View frame;
	private String ip="83.250.249.187",user="lucas",pwd="1q2w3e";
		public  void start() {
			
			
	        
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new View(driver.this);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();//test only
					}
				}
			});
			}
		
		public void q1(String value1, String value2,String value3){
			connect("insert into music (Artist,Title,Genre"
						+ ") values ('"+value1+"', '"+value2+"', '"+value3+"'");
					
		}
		
		
	public void connect(String sqlquery){
		 String server = 
	    			"jdbc:mysql://"+ip+":3306/" + "labb1" +"?UseClientEnc=UTF8"; 
	        
		 Connection con = null;
	        try {	
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(server, user, pwd);
				System.out.println("Connected!");

				
				Superquery query =new Superquery(con);
				query.executeQuery(sqlquery);
	        }
			catch(Exception e) {
				javax.swing.JOptionPane.showMessageDialog(null, 
					"Database error, " + e.toString() );
				 e.printStackTrace();
			}
	        finally {
	        	try {
	        		if(con != null) {
	        			con.close();
	        			System.out.println("Connection closed.");
	        		}
	        	} 
	        	catch(SQLException e) {}
	        }
		
	}
	
	
		
	
}
