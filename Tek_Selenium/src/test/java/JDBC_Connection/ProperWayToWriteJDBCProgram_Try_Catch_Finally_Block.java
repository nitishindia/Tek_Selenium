package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ProperWayToWriteJDBCProgram_Try_Catch_Finally_Block {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
	try {	
		// step 1 : load/register the database driver
	   Driver d = new Driver();
	   DriverManager.registerDriver(d);
		
		// step 2 : connect to database
		 conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
		// step 3 : create sql statement
		Statement stat = conn.createStatement();
		
		// step 4 : Execute select query & get result
		ResultSet result = stat.executeQuery("select * from project");
//		result.next();
//		System.out.println(result.getInt(1));
		while(result.next()) {
		System.out.println(result.getString(1)+"\t"+ result.getString(2)+"\t"+ result.getString(3)+"\t"+ result.getString(4)+"\t"+ result.getString(5)+"\t"+ result.getInt(6));
		}
		
	}
	catch(Exception e) {
		System.out.println("Exception handled");
	}
	finally {
		// step 5 : close the connection
		conn.close();
		System.out.println("=========Close the connection========");
	}

 }

}
