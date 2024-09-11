package JDBC_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		// step 1 : load/register the database driver
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		
		// step 2 : connect the database
		Connection c = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
		// step 3 : Create sql statement
		Statement s = c.createStatement();
		
		// step 4 : execute Query and get result
		int result = s.executeUpdate("insert into project values('2_QSP_Nitish','2_Nitish','20/05/2024','Qspider','ongoing','1')");
		System.out.println(result);
		
		// Step 5 : close connection
		c.close();
	}

}
