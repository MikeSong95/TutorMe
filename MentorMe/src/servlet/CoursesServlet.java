package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.UserController;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
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
		String school = request.getParameter("school");
		String program = request.getParameter("program");
		String course1 = request.getParameter("course1");
		String course2 = request.getParameter("course2");
		String course3 = request.getParameter("course3");
		String course4 = request.getParameter("course4");
		
		// DB Controller
		UserController userController = UserController.getInstance();
		
		HashMap<String, String> courses = new HashMap();
		
		// Session variables
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String type = (String) session.getAttribute("type");
		
		courses.put("school", school);
		courses.put("program", program);
		courses.put("course1", course1);
		courses.put("course2", course2);
		courses.put("course3", course3);
		courses.put("course4", course4);
		
		if (type == "student") {
			userController.modifyStudent(email, courses);
		} else {
			userController.modifyTutor(email, courses);
		}
	}
}