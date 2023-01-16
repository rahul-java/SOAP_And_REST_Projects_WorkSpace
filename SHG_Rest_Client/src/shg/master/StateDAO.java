package shg.master;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import shg.bean.DistrictBean;
import shg.bean.StateBean;
import shg.utility.JDBCUtility;

public class StateDAO {
	
	static Connection con=null;
	
	public List<StateBean> getStateDetails()
	{
		List<StateBean> l=new ArrayList<StateBean>();
		try {
			 con = JDBCUtility.getConn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{       StateBean sb = new StateBean ();
			
				sb.setStCode(rs.getString(1));
				sb.setStName(rs.getString(2));
				sb.setShortName(rs.getString(3));
				//System.out.println(sb.getStCode());
				l.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public List<DistrictBean>  getAllDistrictOfState(String stCode)
	{
		con=JDBCUtility.getConn();
		//System.out.println(stCode);
		 List<DistrictBean> l=new ArrayList<DistrictBean>();
		try {
			
			 PreparedStatement ps = con.prepareStatement("select * from mst_district where state_code=?");
			ps.setString(1, stCode);
			 ResultSet rs = ps.executeQuery();
			 
			 while(rs.next())
			 {
				 DistrictBean db=new DistrictBean();
				 
				 db.setDist_code(rs.getString(1));
				 db.setDist_name(rs.getString(2));
				 db.setDist_state_code(rs.getInt(3));
				// System.out.println(rs.getString(2));
				l.add(db);
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
