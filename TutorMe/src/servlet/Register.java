package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import admin.ServerProperties;
import backend.DatabaseControl;

import java.sql.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        try{
        	
            Connection con=DatabaseControl.getInstance().getConnection();
              
             //check if the name is registered , if so, redirect user 
              
              if (DatabaseControl.getInstance().checkExistence("Users",name)){
            	  out.println("<font color='red'><b>The user name: " + name +" is already resgistered</b></font>");
                  RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                  rd.include(request, response);
                  return;
              }
        	 
        	 PreparedStatement ps=con.prepareStatement
                     ("insert into Users values(?,?,?)");
        	 
        	 ps.setString(1, name);
             ps.setString(2, email);
             ps.setString(3, pass);
             
             int i=ps.executeUpdate();
             
             if(i>0)
             {
               out.println("You are sucessfully registered");
             }
             
        } catch(Exception e){
            e.printStackTrace();
        }
        
		//doGet(request, response);
		 
	}

}
