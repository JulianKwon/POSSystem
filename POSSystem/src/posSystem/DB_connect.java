package posSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_connect {
	private String username = "ID";
	private String password = "PW";
	private static Connection dbTest;

	private void connectDB()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			dbTest = DriverManager.getConnection("jdbc:oracle:thin:" + "@loacalhost:1521:XE", "system", "system");
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("SQLException:" + e);
		} catch (Exception e)
		{
			System.out.println("Exception :" + e);
		}
	}

	public void execute_query() throws SQLException
	{
		String sqlStr = "SELECT avg(speed) FROM PC";
		PreparedStatement stmt = dbTest.prepareStatement(sqlStr);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next())
		{
			System.out.println("avg(speed): " + rs.getFloat("AVG(speed)"));
		}
		rs.close();
		stmt.close();
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DB_connect cdb = new DB_connect();
		try{
			cdb.execute_query();
			dbTest.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("SQLException: " + e);
		}
	}
}
