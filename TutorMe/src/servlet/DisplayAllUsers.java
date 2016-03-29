package servlet;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import backend.DatabaseControl;

public class DisplayAllUsers extends HttpServlet {
	
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
        
        ResultSet allusers= DatabaseControl.getInstance().GetAllUsers();
        if(allusers != null)
        {	
        	StringBuilder outputTable = new StringBuilder();
        	outputTable.append("<table class='table table-hover'>");
        	while(allusers.next()){
        		outputTable.append("<tr>");
        		outputTable.append("<td>user name: " + allusers.getString("name") + "</td>");
        		outputTable.append("</tr>");
        		outputTable.append("<tr>");
        		outputTable.append("<td>user Email: " + allusers.getString("email") + "</td>");
        		outputTable.append("</tr>");
        		outputTable.append("<tr>");
        		outputTable.append("<td> </td>");
        		outputTable.append("</tr>");
        	}
        	outputTable.append("</table>");
        	out.print(outputTable.toString());
        }
        else
         {
         out.println("<font color='red'><b>Ero during user searchr</b></font>");
            }
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {            
            out.close();
        }
        
    }
}