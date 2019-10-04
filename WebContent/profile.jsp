<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true" import="com.ltil.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME<%User user = (User)session.getAttribute("user"); %>
<%=user.getUsername() %></h1>
<table>
	<tr>
		<td><img src="image/iphone.jfif" alt="iphone"></td>
		<td><img src="image/samsung.jfif" alt="samsung"></td>
	</tr>
	<tr>
		<td><img src="image/one_plus.jfif" alt="one_plus"></td>
		<td><img src="image/lenovo.jfif" alt="lenovo"></td>
	</tr>
</table>
	<a href="Hello.jsp">Click here</a>	
</table>
</body>
</html>