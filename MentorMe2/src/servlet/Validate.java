package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import backend.DatabaseControl;

public class Validate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
     try {
         String name = request.getParameter("user");
        String password = request.getParameter("pass");

        if(DatabaseControl.getInstance().checkUser(name, password))
        {	
        	HttpSession session = request.getSession();
            session.setAttribute("user", name);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.include(request, response);
        }
        else
         {
         out.println("<font color='red'><b>You have entered incorrect password, please register</b></font>");
                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.include(request, response);
            }
        }finally {            
            out.close();
        }
        
    }
}