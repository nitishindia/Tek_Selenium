package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ConnectToDatabase {

	public static void main(String[] args) throws Throwable {
		
		// Step 1:load/register the driver
		Driver dri = new Driver();
		DriverManager.registerDriver(dri);
		
		//Step2: get connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
		//Step 3: create statement
		Statement statem = conn.createStatement();
		
		//step 4:exeute query
		ResultSet data = statem.executeQuery("select * from project");
		//data.next();
		//System.out.println(data.getString(1)+"\t"+data.getString(2)+"\t"+data.getString(3)+"\t"+data.getString(4)+"\t");
		while(data.next()) {
		//	System.out.println(data.getString(2));
			System.out.println(data.getString(1)+"\t"+data.getString(2)+"\t"+data.getString(3)+"\t"+data.getString(4)+"\t");

		}
	}

}
