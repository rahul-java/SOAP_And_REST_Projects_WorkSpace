package soa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtility {
	private JDBCUtility()
	{
		
	}
	private static Connection con;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/abc", "postgres", "postgres");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnnn()
	{
		return con;
	}
	
	
	public static int getFid(Connection con)
	{  try {
		
		       PreparedStatement ps = con.prepareStatement("select max(f_id) as fd from father_19");
	   ResultSet rs = ps.executeQuery();
		       while(rs.next())
		       {
		    	  int fd= rs.getInt("fd");
		    	  return fd+1;
		       }
		       
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
		
	}
	
	
	
	public static int getCd(int cid)
	{
		return cid+1;
	}
	
	
	public static int getCID(Connection con)
	{
		try {
			
		       PreparedStatement ps = con.prepareStatement("select max(c_id) as cd from child_19");
	   ResultSet rs = ps.executeQuery();
		       while(rs.next())
		       {
		    	  int cd= rs.getInt("cd");
		    	  return cd+1;
		       }
		       
	} catch (Exception e) {
		e.printStackTrace();
	}
		return 0;
	}

}
