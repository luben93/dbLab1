package controller;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

public class Superquery {
private ArrayList<String> result;
private ArrayList<Object> result1;
private String query;
private Connection con;
	public Superquery(Connection con){
		result=new ArrayList<String>();
		result1=new ArrayList<Object>();
		this.con=con;

		this.query=query;
	}
	
	public ArrayList<Object> getResult(){
		return result1;
	}
	
	public void executeQuery(String query) throws SQLException {
		
		Statement stmt = null;
	    try {
	    	// Execute the SQL statement
	    	stmt = con.createStatement();
	    	ResultSet rs = stmt.executeQuery(query);
	    	
	    	// Get the attribute names
	    	ResultSetMetaData metaData = rs.getMetaData();
	    	int ccount = metaData.getColumnCount();
	    	for(int c = 1; c <= ccount; c++) {
	    		System.out.print(metaData.getColumnName(c) + "\t");
	    	}
	    	System.out.println();
	    	
	    	// Get the attribute values
	    	while (rs.next()) {
    			// NB! This is an example, not the preferred way to retrieve data.
    			// You should use methods that return a specific data type, like
    			// rs.getInt(), rs.getString() or such.
    			// It's also advisable to store each tuple (row) in an object of
    			// custom type (e.g. Employee).
	    		for(int c = 1; c <= ccount; c++) {
	    			result.add(rs.getString(c));
	    			result1.add(rs.getObject(c)+"");
	    			System.out.print(rs.getObject(c) + "\t");
	    		}
		        //System.out.println();
	    	}
	    	
	    }	
	    finally {
	    	if (stmt != null) { 
	    		stmt.close(); 
	    	}
	    }
	}
}
