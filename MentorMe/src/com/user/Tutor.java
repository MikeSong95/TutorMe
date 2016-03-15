package com.user;

import java.util.HashMap;

public class Tutor extends User {
	
	private String[] coursesTeaching=new String[5];
	private String schoolAttended; // or attending
	private String programAttended; //or attending
	
    
	
	public Tutor(HashMap<String, String> user) {
		
		super(user);
		// TODO Auto-generated constructor stub
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
	void updateInfo(HashMap<String, String> user) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
