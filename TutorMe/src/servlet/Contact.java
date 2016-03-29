package servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
@WebServlet("/Contact")
public class Contact extends HttpServlet{
    
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Recipient's email ID needs to be mentioned.
	  
	  final String username = "mentormetest1@gmail.com";
	  final String password = "new2you!";
	  
	  Properties props = new Properties();
	  
	    props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
      String to = "tutormeemails@gmail.com";
 
      // Sender's email ID needs to be mentioned
      String from = "mentormetest@outlook.com";
 
      // Assuming you are sending email from localhost
  
 
      // Get the default Session object.
      Session session = Session.getInstance(props,
    		  new javax.mail.Authenticator() {
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(username, password);
    			}
    		  });
      
	  // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
         // Set Subject: header field
         message.setSubject("Inqury from USER: " + request.getParameter("userName") + " EMAIL: " +request.getParameter("email"));
         // Now set the actual message
         String content = request.getParameter("message");
         message.setText("Message: " +content);
         // Send message
         Transport.send(message);
         System.out.println("Sending email");
         // Redirect to index page
         response.sendRedirect("index.jsp");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
} 