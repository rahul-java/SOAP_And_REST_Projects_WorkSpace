package max.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.bean.MemberNBean;
import max.bean.SHGBean;
import max.dao.Save_Into_DB;



@WebServlet("/ShgDetails")
public class ShgDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		String gname=request.getParameter("gname");
		String an=request.getParameter("an");
		String ifsc=request.getParameter("ifsc");
		String bankName=request.getParameter("bank_name");
		String branchName=request.getParameter("branch_name");
		String stCode=request.getParameter("stCode");
		String districtCode=request.getParameter("districtCode");
		
		System.out.println("shgdetail "+districtCode);
		SHGBean sHGBean=new SHGBean();
		sHGBean.setGname(gname);
		sHGBean.setAn(an);
		sHGBean.setIfsc(ifsc);
		sHGBean.setBankName(bankName);
		sHGBean.setBranchName(branchName);
		sHGBean.setStCode(stCode);
		sHGBean.setDistrictCode(districtCode);
		
		String[] mname = request.getParameterValues("mname");
		String[] mage = request.getParameterValues("mage");
		String[] madhar = request.getParameterValues("madhar");
		int count=0;
		List<MemberNBean> list = new ArrayList<MemberNBean>();
		for(int i=0;i<mname.length;i++)
		{
			MemberNBean memberNBean=new MemberNBean();
			memberNBean.setMname(mname[i]);
			memberNBean.setMage(mage[i]);
			memberNBean.setMadhar(madhar[i]);
			//memberNBean.setShgBean(sHGBean);
			list.add(memberNBean);
			count++;
		}
		
		sHGBean.setMbean(list);
		if(count>=2)
		{
		if(Save_Into_DB.insert_Details(sHGBean))
		{
			out.println("Data is inserted");
		}
		else
		{
			out.println("Data is not inserted");
		}
		}
		else
		{
			out.println("At least two member ");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
