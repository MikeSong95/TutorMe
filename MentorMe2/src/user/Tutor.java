package user;

import java.util.HashMap;

public class Tutor extends User {
	
	private String[] coursesTeaching=new String[5];
	private String schoolAttended; // or attending
	private String programAttended; //or attending
	
    
	
	public Tutor(HashMap<String, String> user) {
		
		super(user);
		
		this.schoolAttended=user.get("schoolAttended");
		this.programAttended=user.get("programAttended");
	
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCourses(String [] courses){
		
		if(courses.length>5)
			return;
		
		this.coursesTeaching=courses;	

		
	}


	public String[] getCoursesTeaching() {
		return coursesTeaching;
	}


	public void setCoursesTeaching(String[] coursesTeaching) {
		this.coursesTeaching = coursesTeaching;
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
	void updateInfo(HashMap<String, String> user,String[] courses) {
		
		
		this.firstName=user.get("firstName");
		this.lastName=  user.get("lastName");
		this.email= user.get("email");
		this.password= user.get("password");
		this.schoolAttended=user.get("schoolAttended");
		this.programAttended=user.get("programAttended");
		addCourses(courses);
		
		// TODO Auto-generated method stub
		
	}
	
	
	
}
