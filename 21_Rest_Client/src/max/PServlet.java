package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ParentsDetailServlet")
public class PServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out = response.getWriter();
	String gname = request.getParameter("gname");
	String dob = request.getParameter("dob");
	String ifsc = request.getParameter("ifsc");
	String stateCode = request.getParameter("stateCode");
	String districtCode = request.getParameter("districtCode");
	String[] cname = request.getParameterValues("cname");
	String[] age = request.getParameterValues("age");
	String[] cadhar = request.getParameterValues("cadhar");
	List<MemberDetails> clist=new ArrayList<MemberDetails>();
	SHGDetails sHGDetails=new SHGDetails();
	sHGDetails.setGname(gname);
	sHGDetails.setDob(dob);
	sHGDetails.setIfsc(ifsc);
	sHGDetails.setStateCode(stateCode);
	sHGDetails.setDistrictCode(districtCode);
	for(int i=0;i<cname.length;i++)
	{
		MemberDetails memberDetails=new MemberDetails ();
		
		memberDetails.setCname(cname[i]);
		memberDetails.setAge(age[i]);
		memberDetails.setCadhar(cadhar[i]);
		clist.add(memberDetails);
	}
	sHGDetails.setMemberDetails(clist);
	String jrst = JSONWrite.generateJSON(sHGDetails);
	ServicesCode.getResponseByServer(jrst);
	
	}

}
