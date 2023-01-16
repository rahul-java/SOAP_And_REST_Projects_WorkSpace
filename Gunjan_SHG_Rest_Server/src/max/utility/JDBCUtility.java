package max.utility;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtility {
	
	
	
	private JDBCUtility()
	{
		
	}
	static Connection cn=null;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
cn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shg_details","postgres","root");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn()
	{
		return cn;
	}

}
