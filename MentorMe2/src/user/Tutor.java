package user;

import java.util.HashMap;

public class Tutor extends User {
	

	private String schoolAttended; // or attending
	private String programAttended; //or attending
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private String school;
	public String getSchool() {
		return school;
	}




	public void setSchool(String school) {
		this.school = school;
	}




	public String getDegree() {
		return degree;
	}




	public void setDegree(String degree) {
		this.degree = degree;
	}



	private String degree;
	private String program;
    
	
	public Tutor(HashMap<String, String> user) {
		
		super(user);
		
		this.schoolAttended=user.get("schoolAttended");
		this.programAttended=user.get("programAttended");
		this.degree=user.get("degree");
		// TODO Auto-generated constructor stub
	}




	public String getCourse1() {
		return course1;
	}




	public void setCourse1(String course1) {
		this.course1 = course1;
	}




	public String getCourse2() {
		return course2;
	}




	public void setCourse2(String course2) {
		this.course2 = course2;
	}




	public String getCourse3() {
		return course3;
	}




	public void setCourse3(String course3) {
		this.course3 = course3;
	}




	public String getCourse4() {
		return course4;
	}




	public void setCourse4(String course4) {
		this.course4 = course4;
	}




	public String getSchoolAttended() {
		return schoolAttended;
	}



	public void setSchoolAttended(String schoolAttended) {
		this.schoolAttended = schoolAttended;
	}



	public String getProgramAttended() {
		return programAttended;
	}



	public void setProgramAttended(String programAttended) {
		this.programAttended = programAttended;
	}



	@Override
	public
	void updateInfo(HashMap<String, String> user) {
		
		
		if(user.get("firstName") != null)
		this.firstName=user.get("firstName");
		if(user.get("lastName") != null)
		this.lastName=  user.get("lastName");
		if(user.get("email") != null)
		this.email= user.get("email");
		if(user.get("password") != null)
		this.password= user.get("password");
		if(user.get("schoolAttended") != null)
		this.schoolAttended=user.get("schoolAttended");
		if(user.get("programAttended") != null)
		this.programAttended=user.get("programAttended");
		if(user.get("course1")!=null)
			this.course1=user.get("course1");		
			if(user.get("course2")!=null)
			this.course2=user.get("course2");			
			if(user.get("course3")!=null)	
			this.course3=user.get("course3");	
			if(user.get("course4")!=null)	
			this.course4=user.get("course4");	
			if (user.get("school")!= null)
			this.school = user.get("school");
			if (user.get("degree")!= null)
			this.degree = user.get("degree");
			if (user.get("program")!= null)
			this.program = user.get("program");
		
		
		// course strings, to be completed
		
		//addCourses(courses);
		
		// TODO Auto-generated method stub
		
	}




	public String getProgram() {
		return program;
	}




	public void setProgram(String program) {
		this.program = program;
	}
	
	
	
}
