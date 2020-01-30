package com.vedantu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vedantu.DataBaseClass;

//annotation
@WebServlet ("/login") 

public class LoginServlet extends HttpServlet{
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String user_name = "", password = "";
		//output
		PrintWriter output = res.getWriter();
		//checking if user_name is null
		if(req.getParameter("user_name") != null) {
			user_name = req.getParameter("user_name");
		}
		
		//checking if password is null
		if(req.getParameter("password") != null) {
			password = req.getParameter("password");
		}
		
		if(!(user_name.isEmpty() || password.isEmpty())){
			DataBaseClass db = new DataBaseClass();
			if(db.checkLogin(user_name, password)) {
				output.println("login successful!!!");
				HttpSession session = req.getSession();
				session.setAttribute("user_name", user_name);
				res.sendRedirect("home.jsp");
			}else {
				output.println("Invalid Details!!!!");
			}
		}else {
			output.println(user_name + " " + password);
			output.println("Please fill all the fileds");
		}
	}
}
