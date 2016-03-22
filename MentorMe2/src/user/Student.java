package user;

import java.util.HashMap;

public class Student extends User {

	private String schoolAttending;
	private String programAttending;
	private String course1;
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


	private String course2;
	private String course3;
	private String course4;
	
	public Student(HashMap<String, String> user) {
		
		super(user);
		
		this.schoolAttending=user.get("schoolAttending");
		this.programAttending= user.get("programAttending");
		// TODO Auto-generated constructor stub
	}
	
	

	public String getSchoolAttending() {
		return schoolAttending;
	}

	public void setSchoolAttending(String schoolAttending) {
		this.schoolAttending = schoolAttending;
	}

	public String getProgramAttending() {
		return programAttending;
	}

	public void setProgramAttending(String programAttending) {
		this.programAttending = programAttending;
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
			if(user.get("school") != null)
			this.schoolAttending=user.get("school");
			if(user.get("program") != null)
			this.programAttending=user.get("program");
			if(user.get("course1")!=null)
			this.programAttending=user.get("program");	
			if(user.get("course1")!=null)
			this.course1=user.get("course1");		
			if(user.get("course2")!=null)
			this.course2=user.get("course2");			
			if(user.get("course3")!=null)	
			this.course3=user.get("course3");	
			if(user.get("course4")!=null)	
			this.course4=user.get("course4");		
				
			
				
			// course stuff to be completed
		//addCourses(courses);
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
