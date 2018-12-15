<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:blue;">
<h1  align= "Center" style="color:white">Registration for PG</h1>
<hr></hr>
<br></br>
<form action= "Controller" method = "post">
<table>
<tr  align= "Center" style="color:white">
<th  align= "Center">NAME :</th>
<td  align= "Center"><input type= "text" name= "name"></td>
</tr>
<tr align= "Center" style="color:white">
<th>AGE :</th>
<td><input type= "text" name= "age"></td>
</tr>

<tr align= "Center" style="color:white">
<th>GENDER:</th>
<td><input type= "text" name= "gender"></td>
</tr>

<tr align= "Center" style="color:white">
<th>PHONE :</th>
<td><input type= "text" name= "phone"></td>
</tr>
<tr>
<td><input type= "submit" name= "action" value="update"></td>
</tr>
</table>
</form>

</body>

</html>