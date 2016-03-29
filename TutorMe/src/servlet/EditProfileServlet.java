package servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.UserController;
import user.Student;
import user.Tutor;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
		// Hashmap of student and tutor data
		HashMap<String, String> studentInfo = new HashMap<String, String>(); 
		HashMap<String, String> tutorInfo = new HashMap<String, String>();
		
		// Either student or tutor
		String type = request.getParameter("type");
		
		// Parameters common to both students and tutors
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// Parameters specific to tutors
		String schoolAttended, degree, programAttended;
		
		// DB Controller
		UserController userController = UserController.getInstance();
		
		// Success
		boolean success;
		
		String school, program, course1, course2, course3, course4;
		
		if (type.equals("student")) {
			// Aggregte information into hashmap
			studentInfo.put("firstName", firstName);
			studentInfo.put("lastName", lastName);
			studentInfo.put("email", email);
			
			// Get school / program / courses
			Student student = userController.getStudent(email);
			
			String password = student.getPassword();
			school = student.getSchoolAttending();
			program = student.getProgramAttending();
			course1 = student.getCourse1();
			course2 = student.getCourse2();
			course3 = student.getCourse3();
			course4 = student.getCourse4();
			
			studentInfo.put("password", password);
			studentInfo.put("school", school);
			studentInfo.put("program", program);
			studentInfo.put("course1", course1);
			studentInfo.put("course2", course2);
			studentInfo.put("course3", course3);
			studentInfo.put("course4", course4);
			
			success = userController.ModifyStudent(email, studentInfo);
		} else {
			// Get parameters specific to tutors
			schoolAttended = request.getParameter("school");
			degree = request.getParameter("degree");
			programAttended = request.getParameter("program");
			
			// Aggregate information into hashmap
			tutorInfo.put("firstName", firstName);
			tutorInfo.put("lastName", lastName);
			tutorInfo.put("email", email);
			tutorInfo.put("schoolAttended", schoolAttended);
			tutorInfo.put("degree", degree);
			tutorInfo.put("programAttended", programAttended);

			// Get school / program / courses
			Tutor tutor = userController.getTutor(email);
			
			school = tutor.getSchool();
			program = tutor.getProgram();
			course1 = tutor.getCourse1();
			course2 = tutor.getCourse2();
			course3 = tutor.getCourse3();
			course4 = tutor.getCourse4();
			String password = tutor.getPassword();
			tutorInfo.put("password", password);
			
			studentInfo.put("school", school);
			studentInfo.put("program", program);
			studentInfo.put("course1", course1);
			studentInfo.put("course2", course2);
			studentInfo.put("course3", course3);
			studentInfo.put("course4", course4);

			success = userController.ModifyTutor(email, tutorInfo);
		}
		
		if (success) {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("type", type);
			response.getWriter().print("success");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("error");
		}
	}

}
