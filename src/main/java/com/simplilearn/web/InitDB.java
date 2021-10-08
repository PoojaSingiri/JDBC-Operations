package com.simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/init-connection")
public class InitDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InitDB() {
        super();
      }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter	out = response.getWriter();
	    
	    request.getRequestDispatcher("index.html").include(request, response);
	    
	    try {
	         String url = "jdbc:mysql://localhost:3306/ecom_webapp";
	         String username = "root";
	         String password = "Pooja@11j";
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection connection = DriverManager.getConnection(url,username,password);
	         if(connection!=null) {
	        	 out.print("<h3 style='color:green'> Your DB connection is successfull!! </h3>");
	         }
	    }catch (Exception e){
	    	out.print("<h3 style='color:red'> Sorry, DB connection failed </h3>");
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
