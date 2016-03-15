package com.user;

import java.util.HashMap;

public class Student extends User {

	private String schoolAttending;
	private String programAttending;
	private String[] coursesLearning= new String[5];
	
	public Student(HashMap<String, String> user) {
		
		super(user);
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

	public String[] getCoursesLearning() {
		return coursesLearning;
	}

	public void setCoursesLearning(String[] coursesLearning) {
		this.coursesLearning = coursesLearning;
	}

	@Override
	void updateInfo(HashMap<String, String> user) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
