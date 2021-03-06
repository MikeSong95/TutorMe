package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.UserController;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserController controller = UserController.getInstance();
		
		PrintWriter res = response.getWriter();
		HttpSession session = request.getSession();

		// Check if it is a student, or tutor, or it doesn't exist / incorrect credentials
		if (controller.validateStudent(email, password)) {
			session.setAttribute("email", email);
			session.setAttribute("type", "student");
			session.setAttribute("name",controller.getStudent(email).getFirst());
			System.out.println("Student " + email + " has logged in.");
			res.print("student");
		} else if (controller.validateTutor(email, password)){
			session.setAttribute("tutorEmail", email);
			session.setAttribute("type", "tutor");
			System.out.println("Tutor " + email + " has logged in.");
			res.print("tutor");
		} else {
			res.print("error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
