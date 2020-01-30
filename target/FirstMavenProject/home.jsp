<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//request,session, response, out => implicit objects (many are there)
	
	// to remove cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

	// to check if loggined by checking session

	if(session.getAttribute("user_name") == null){
		response.sendRedirect("login.jsp");
	}
%>
<body  align="center">
<h1>Hai <b><%= session.getAttribute("user_name") %></b>.Welcome to Home Page</h1>
<p>This is home page. You have logged in successfully. Now you can access all the resources that requir
Please be careful with this page. Whenever you are out of this page, please logout.
</p>

<p>You can logout here <a href="logout">Logout</a></p>
</body>
</html>