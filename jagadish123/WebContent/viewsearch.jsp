<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="bean.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	ArrayList<Customer> alist = (ArrayList<Customer>)request.getAttribute("alist");
%>
<body>
<form>
<table border="1">
<tr>
<th>name</th>
<th>age</th>
<th>gender</th>
<th>phone</th>
<th>action</th>
</tr>
<%
	for(Customer c: alist){
%>
<tr>
<td><%=c.getName()%></td>
<td><%=c.getAge()%></td>
<td><%=c.getGender()%></td>
<td><%=c.getPhone()%></td>
<td><a href="Controller?action=delete&name=<%=c.getName()%>">delete</a></td>
</tr>
<%} %>
</table>
</form>


</body>
</html>