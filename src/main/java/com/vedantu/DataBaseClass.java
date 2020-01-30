package com.vedantu;
import java.sql.*;
public class DataBaseClass {
	
	
	String url = "jdbc:mysql://localhost:3306/servletDatabase";
	String user = "root";
	String dbPassword = "youMySQLServerPassword"; 	// password of mysql server

	public boolean checkLogin(String username, String password){
		String query = "select * from users where user_name = ? and password = ?";
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user, dbPassword);  
			//here users is database name, root is user name and password  
			PreparedStatement stmt=con.prepareStatement(query); 
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs=stmt.executeQuery(); 
//			while(rs.next())
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			if(rs.next()) {
				return true;
			}
			con.close();  
		}catch(Exception e){ System.out.println(e); /* here sendRedirect to error page */}
		
		return false;
	}
	
	public boolean insertUser(String username, String password) {
		String query = "INSERT INTO users (user_name, password) values (?, ?)";
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(url,user, dbPassword);  
			//here users is database name, root is user name and password  
			PreparedStatement stmt=con.prepareStatement(query); 
			stmt.setString(1, username);
			stmt.setString(2, password);
			int rs= stmt.executeUpdate(); 
//			while(rs.next())
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  }
			if(rs == 1) {
				return true;
			}
			con.close();  
		}catch(Exception e){ System.out.println(e); return false; /* here sendRedirect to error page */}
		
		return true;
	}
}
