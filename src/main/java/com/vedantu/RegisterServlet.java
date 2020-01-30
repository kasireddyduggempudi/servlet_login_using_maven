package com.vedantu;

import java.io.IOException;
import com.vedantu.DataBaseClass;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet ("/register")
public class RegisterServlet extends HttpServlet{
	
//	public void service(HttpServletRequest req, HttpServletResponse res) {
//		// this method is called default
//	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		// checking if user name is null, means user_name name is not there in form
		String user_name = "", password="", confirm_password="";
		if(req.getParameter("user_name") != null) {
			user_name = req.getParameter("user_name"); 
		}
		
		//checking if password is null, means password name is not there in form
		
		if(req.getParameter("password") != null) {
			password = req.getParameter("password");
		}
		
		//checking if confirm password is null
		
		if(req.getParameter("confirm_password") != null) {
			confirm_password = req.getParameter("confirm_password");
		}
		
		if((!(user_name.isEmpty() || password.isEmpty() || confirm_password.isEmpty())) && (password.equals(confirm_password))){
			// call the database connection and insert the data to database
			PrintWriter output = res.getWriter();
			//output.println("Thank you.");
			
			DataBaseClass db = new DataBaseClass();
			if(db.insertUser(user_name, password)){
				output.println("Thank you for registration. Please Login!!!!");
			}else {
				output.println("Error at registration. Please hold on");
			}
			
		}else{
			PrintWriter output = res.getWriter();
			output.println("Please Enter valid details.");
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.sendRedirect("register.jsp");
	}
}
