<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//checking if already logged in
// response, request, session, out =>implicit objects
// to remove cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("user_name") != null){
		response.sendRedirect("home.jsp");
	}
%>
<body align="center">
<h1>Login</h1>
<form action="login" method="post">
	UserName : <input type="text" name="user_name" required="required" /><br /><br />
	Password : <input type="password" name="password" required="required" /><br /><br />
	<input type="submit" name="submit" value="Login" />
	
	<p>If you don't have an account, please <a href="register.jsp">register</a></p>
</form>
</body>
</html>