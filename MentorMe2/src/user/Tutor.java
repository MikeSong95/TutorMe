package user;

import java.util.HashMap;

public class Tutor extends User {
	

	private String schoolAttended; // or attending
	private String programAttended; //or attending
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	
    
	
	public Tutor(HashMap<String, String> user) {
		
		super(user);
		
		this.schoolAttended=user.get("schoolAttended");
		this.programAttended=user.get("programAttended");
	
		// TODO Auto-generated constructor stub
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
		
		
		// course strings, to be completed
		
		//addCourses(courses);
		
		// TODO Auto-generated method stub
		
	}
	
	
	
}
