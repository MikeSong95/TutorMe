package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import control.UserController;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * Adds student or tutor into the database.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Hashmap of student and tutor data
		HashMap<String, String> studentInfo = new HashMap<String, String>(); 
		HashMap<String, String> tutorInfo = new HashMap<String, String>();
		
		// Either student or tutor
		String type = request.getParameter("type");
		
		// Parameters common to both students and tutors
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Parameters specific to tutors
		String school, degree, program;
		
		// DB Controller
		UserController userController = UserController.getInstance();
		
		HttpSession session = request.getSession();
		
		// Success
		boolean success;
		
		if (type.equals("student")) {
			// Aggregte information into hashmap
			studentInfo.put("firstName", firstName);
			studentInfo.put("lastName", lastName);
			studentInfo.put("email", email);
			studentInfo.put("password", password);
			
			success = userController.CreateStudent(email, studentInfo);
			
			session.setAttribute("email", email);
		} else {
			// Get parameters specific to tutors
			school = request.getParameter("school");
			degree = request.getParameter("degree");
			program = request.getParameter("program");
			
			// Aggregate information into hashmap
			tutorInfo.put("firstName", firstName);
			tutorInfo.put("lastName", lastName);
			tutorInfo.put("email", email);
			tutorInfo.put("password", password);
			tutorInfo.put("schoolAttended", school);
			tutorInfo.put("degree", degree);
			tutorInfo.put("programAttended", program);
			
			success = userController.createTutor(email, tutorInfo);	
			
			session.setAttribute("tutorEmail", email);
		}
		
		if (success) {
			response.setContentType("text/html;charset=UTF-8");
			
			session.setAttribute("type", type);
			response.getWriter().print("success");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("error");
		}
	}

}
