package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLupdate extends Superquery {

	public SQLupdate(Connection con) {
		super(con);
		// TODO Auto-generated constructor stub
	}
	
public void execute(String query) throws SQLException {
		
		Statement stmt = null;
	    try {
	    	// Execute the SQL statement
	    	stmt = super.con.createStatement();
	 
	    	
	    }	
	    finally {
	    	if (stmt != null) { 
	    		stmt.close(); 
	    	}
	    }
	}


}
