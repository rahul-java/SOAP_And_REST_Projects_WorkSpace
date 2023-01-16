<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="max.SHGBean" %>
    <%@ page import="max.MemberNBean" %>
    <%@ page import="java.util.Set" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>
<%
Set<SHGBean> l=(Set<SHGBean>)request.getAttribute("list");
for(SHGBean m:l)
{
%>
<tr><td><%=m.getShg_id() %><td><td><%=m.getGname() %><td><td><%=m.getBankName() %><td><td><%=m.getAn() %><td><td><%=m.getIfsc() %><td><td><%=m.getBranchName() %><td><td><%=m.getStCode() %><td><td><%=m.getDistrictCode() %><td></tr>
<% List<MemberNBean> b =m.getMbean(); 
for(MemberNBean mn:b)
{
%>
<tr><td><%=mn.getMname() %></td><td><%=mn.getMage() %></td><td><%=mn.getMadhar() %></td></tr>
<% }} %>

</table>
</body>
</html>