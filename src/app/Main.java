package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.sqlite.SQLiteDataSource;
import org.sqlite.SQLiteJDBCLoader;

import db.Database;
import db.Generator;
import db.Sqlite;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Connecting database
		Properties props=new Properties();
		props.setProperty(Sqlite.PROPERTY_FILENAME, "data.sqlite");

		Database db=new Sqlite();
		db.connect(props);
		
		// Creating/updating structure
		try {
			db.executeUpdate("DROP TABLE users");			
		} catch (Exception e) {
			//Table does not exist
		}
		db.executeUpdate("CREATE TABLE users (id integer PRIMARY KEY, email varchar(50), password varchar(32) ) ");
		
		// Filling random data
		try {
			for (int i = 0; i < 30; i++) {
				db.executeUpdate(String.format("INSERT INTO users (email, password) values ('%s','%s')",Generator.getWord(4,6, true)+" "+Generator.getWord(5,8, true),Generator.getWord(8,12,false)));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Showing random data
		ResultSet rs=db.executeQuery("SELECT ROWID as rowid,u.* from users u");
		while(rs.next()){
			ArrayList<String> row=new ArrayList<String>();
			row.add(rs.getString("rowid"));
			row.add(rs.getString("id"));
			row.add(rs.getString("email"));
			row.add(rs.getString("password"));
			System.out.println(row);
		}
	}

	
}
