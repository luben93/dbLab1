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
	private String ip = "83.250.249.187", user = "lucas", pwd = "1q2w3e";

	public void start() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new View(driver.this);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();// test only
				}
			}
		});
	}

	public void q1(String value1, String value2, String value3) {
		connect("insert into music (artist,album,genre" + ") values ('"
				+ value1 + "', '" + value2 + "', '" + value3 + "')", 1);

	}

	public void q2(String value1, String value2) {
		connect("Select * FROM music where " + value1 + " like '" + value2
				+ "%'", 2);

	}

	public void connect(String sqlquery, int type) {// type 1 = update,type
													// 2=query
		String server = "jdbc:mysql://" + ip + ":3306/" + "labb1"
				+ "?UseClientEnc=UTF8";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(server, user, pwd);
			System.out.println("Connected!");

			switch (type) {
			case 1:
				SQLupdate update = new SQLupdate(con);
				update.execute(sqlquery);
				break;
			case 2:
				SQLquery query = new SQLquery(con);
				System.out.println( query.execute(sqlquery));
				break;
			}

			/*
			 * SuperSQL query ;//=new Superquery(con); switch(type){ // case
			 * 1:query.executeUpdate(sqlquery);break; //case
			 * 2:query.executeQuery(sqlquery);break; case 1: query= new
			 * SQLupdate(con); ((SQLupdate) query).execute(sqlquery); break;
			 * case 2: query =new SQLquery(con); System.out.println(((SQLquery)
			 * query).execute(sqlquery)); break; }
			 */
			// query.executeUpdate(sqlquery);
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
			}
		}

	}

}
