<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%--  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>
    <jsp:useBean id="ob" class="shg.master.StateDAO"></jsp:useBean>
    <%@ page import="java.util.List" %>
    <%@ page import="shg.bean.StateBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script language="javascript">
/* function getAdharDetail() {
	
var adhar=document.getElementById("adhar").value;
  var xmlhttp;


if (window.XMLHttpRequest)
{
// code for IE7+, Firefox, Chrome, Opera, Safari
     xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 }
 
 xmlhttp.onreadystatechange=function()
 {
 if (xmlhttp.readyState==4 && xmlhttp.status==200)
{
//document.getElementById("fname").value
 var s=xmlhttp.responseText;
       t=s.split(",");
     document.getElementById("t1").value=t[0];
     document.getElementById("t2").value=t[1];
}
  
 }
  xmlhttp.open("GET","AdharServlet?adhar="+adhar,true);
      xmlhttp.send();
} */


function getDistrictName() {
var sCode=document.getElementById("stateCode").value;
  var xmlhttp;


if (window.XMLHttpRequest)
{
// code for IE7+, Firefox, Chrome, Opera, Safari
     xmlhttp=new XMLHttpRequest();
}
else
{// code for IE6, IE5
 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
 }
 xmlhttp.onreadystatechange=function()
 {
 if (xmlhttp.readyState==4 && xmlhttp.status==200)
{

document.getElementById("print").value=xmlhttp.responseText;
}
  
 }
  xmlhttp.open("GET","StateMasterServlet?sCode="+sCode,true);
      xmlhttp.send();
}

   function addRow()
   {
   var table=document.getElementById("child");
   var rowCount=table.rows.length;
   var row=table.insertRow(rowCount);
   var cell1=row.insertCell(0);
   cell1.innerHTML=rowCount-1;
   var cell2=row.insertCell(1);
   
   var element2=document.createElement("input");
   element2.type="checkbox";
   element2.name="chk";
   cell2.appendChild(element2);
   var cell3=row.insertCell(2);
   
   var element3=document.createElement("input");
   element3.type="text";
   element3.name="cname";
   cell3.appendChild(element3);
   var cell4=row.insertCell(3);
   
   var element4=document.createElement("input");
   element4.type="text";
   element4.name="age";
   cell4.appendChild(element4);
   var cell5=row.insertCell(4);
   
   var element5=document.createElement("Select");
   element5.name="gender";
   var option = document.createElement("OPTION");
   option.innerHTML = "Male";
   option.value="Male";
   element5.options.add(option);
   var option = document.createElement("OPTION");
   option.innerHTML = "Female";
   option.value="Female";
   element5.options.add(option);
   cell5.appendChild(element5);
   var cell6=row.insertCell(5);
   
   var element6=document.createElement("input");
   element6.type="text";
   element6.name="cadhar"; 
   cell6.appendChild(element6);
   
   
   }

   function deleteRow()
   {
     var table=document.getElementById("child");
     var rowCount=table.rows.length;
	 for(var i=3;i<rowCount;i++)
		 {
		  var row=table.rows[i];
		  var chkbox = row.cells[1].childNodes[0];
		  if(chkbox != null && chkbox.checked == true)
		    {
				table.deleteRow(i);
				rowCount--;
				i--;
			}
		 }
	
   }
   
   function getAllDistrict(stCode)
   {
	   var req;    
		 
		  if (window.XMLHttpRequest)
		  	{
		  	     // code for IE7+, Firefox, Chrome, Opera, Safari
		  	     req=new XMLHttpRequest();
		  	}
		  	else
		  	{    // code for IE6, IE5
		  	     req=new ActiveXObject("Microsoft.XMLHTTP");
		  	 }
			  
			  req.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      document.getElementById("select_District").innerHTML = this.responseText;
			    }
			  };
			  req.open("GET", "District_Servlet?stCode="+stCode, true);
			  req.send();
   }
   
   
   function getBankDetail(ifsc)
   {
	   var req;    
		 
		  if (window.XMLHttpRequest)
		  	{
		  	     // code for IE7+, Firefox, Chrome, Opera, Safari
		  	     req=new XMLHttpRequest();
		  	}
		  	else
		  	{    // code for IE6, IE5
		  	     req=new ActiveXObject("Microsoft.XMLHTTP");
		  	 }
			  
			  req.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      document.getElementById("bankDetail").innerHTML = this.responseText;
			    }
			  };
			  req.open("GET", "Bank_Detail_Servlet?ifsc="+ifsc, true);
			  req.send();
   }

   function validateAdharAndAge()
	{
		var age = document.getElementById("cAge").value;
		var adhar = document.getElementById("cAdhar").value;
		if (age >= 18 && age <= 60)
		{
			if(adhar.length==12)
				{
				return true;
				}
			else
				{
				alert("Your Aadhar Number is not valid...");
				return false;
				}
			
		} else {
			alert("Your Age is not between 18 to 60");
			return false;
		}

	}
</script>

<title>Insert title here</title>
</head>
<body>
<form action="ChildParentDetails" method="post" onsubmit="return validateAdharAndAge()">
<table id="parent" bgcolor="yellowgreen" border ="3">
<tr>
  <th colspan="4" align="center">Self Help Group</th>
</tr>
<tr >    
<th>Group Name :</th><td><input type="text" name="gname" ></td></tr>
<tr><th>Account No :</th><td><input type="text" name="an"></td>
<th>IFSC :</th><td><input type="text" name="ifsc"  id="ifsc" onblur="getBankDetail(this.value);"></td></tr>
<tr id="bankDetail"></tr>

<tr><th>State Name</th><td><select name="stateCode" onchange="getAllDistrict(this.value)">
                                  <option value="0">select state</option>
                                  
<%

         List<StateBean> list=ob.getStateDetails();
                                  
                                  for(StateBean p:list)
                                  {                         
%>

<option value="<%=p.getStCode()%>" > <%=p.getStName()%> </option>
                                  
                                  <% } %>
								  </select></td>


<th>District Name</th>
                      <td><select name="districtCode" id="select_District">
                      
                                   <option value="0">select District</option>
								    
								  </select></td>
</tr>
</table>
<table id="child" bgcolor="yellow" border ="3">
  <tr>
   <th colspan="4" align="center">Member's Detail </th>
   <th align="right"> <input type="button" id="b1"  onclick="addRow();">Add More Member</th>
   <th align="right"> <input type="button" id="b2"  onclick="deleteRow();">Remove Member</th>
</tr>
  <tr>
     <th>S.No.</th><th>Select</th><th>Member Name</th><th>Age</th><th>Gender</th><th>Aadhar</th>
  </tr>
  <tr>
     <td>1</td><td><input type="checkbox" name="chk"></td>
     <td><input type="text" name="cname"></td>
     <td><input type="text" name="age" id="cAge"></td>
     <td><select name="select_gender">
                         <option value="0">select</option>
                         <option value="Male">Male</option>
                                  <option value="Female">Female</option>
								  </select></td>
     <td><input type="text" name="cadhar" id="cAdhar"></td>
  </tr>
  
</table>
<table>
<tr><td><input type="submit" value="Save"></td>
<td><a href=ViewChildParentDetails>View</a></td>
</tr>
</table>

</form>
</body>
</html>