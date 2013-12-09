package controller;
import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

public abstract class Superquery {
protected ArrayList<Array> result;
//private ArrayList<Object> result1;
private String query;
protected Connection con;
	public Superquery(Connection con){
		result=new ArrayList<Array>();
		//result1=new ArrayList<Object>();
		this.con=con;

		this.query=query;
	}
	
	public ArrayList<Array> getResult(){
		return result;
	}
	
	

	
}
