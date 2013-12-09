package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLquery {
	private Connection con;
	private ArrayList<Music> result;

	public SQLquery(Connection con) {
		this.con = con;
		result = new ArrayList<Music>();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Music> execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Get the attribute names
			ResultSetMetaData metaData = rs.getMetaData();
			int ccount = metaData.getColumnCount();
			for (int c = 1; c <= ccount; c++) {
				System.out.print(metaData.getColumnName(c) + "\t");
			}
			System.out.println();
			Music musiccol;
			// Get the attribute values
			while (rs.next()) {
				// NB! This is an example, not the preferred way to retrieve
				// data.
				// You should use methods that return a specific data type, like
				// rs.getInt(), rs.getString() or such.
				// It's also advisable to store each tuple (row) in an object of
				// custom type (e.g. Employee).
				for (int c = 1; c <= ccount; c++) {
					musiccol = new Music(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5));
					System.out.print(rs.getObject(c) + "\t");

					//result.add(musiccol);
				}
				System.out.println();
				result.add(new Music(rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5)));
				// result.add(rs.getArray("artist"));//dose not work
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
}
