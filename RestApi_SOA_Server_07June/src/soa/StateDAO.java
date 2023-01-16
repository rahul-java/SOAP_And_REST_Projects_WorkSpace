package soa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StateDAO {

	public StateMasterList getStateDetails() {
		StateMasterList stateMasterList = new StateMasterList();
		stateMasterList.setList(new ArrayList<StateBean>());
		try {
			Connection con = JDBCUtility.getConnnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				StateBean stateBean = new StateBean();

				stateBean.setStCode(rs.getString(1));
				stateBean.setStName(rs.getString(2));
				stateBean.setStShortName(rs.getString(3));

				
				stateMasterList.getList().add(stateBean);
			}
		}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		return stateMasterList;
		
		}
	}

	
		

	

