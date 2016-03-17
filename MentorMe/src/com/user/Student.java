package com.user;

import java.util.HashMap;

public class Student extends User {

	private String schoolAttending;
	private String programAttending;
	private String[] coursesLearning= new String[5];
	
	public Student(HashMap<String, String> user) {
		
		super(user);
		
		this.schoolAttending=user.get("schoolAttending");
		this.programAttending= user.get("programAttending");
		// TODO Auto-generated constructor stub
	}
	
	
	
    public void addCourses(String [] courses){
		
		if(courses.length>5)
			return;
		
		this.coursesLearning=courses;	

		
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
	public
	void updateInfo(HashMap<String, String> user, String[] courses) {
		
		this.firstName=user.get("firstName");
		this.lastName=  user.get("lastName");
		this.email= user.get("email");
		this.password= user.get("password");
		this.schoolAttending=user.get("schoolAttending");
		this.programAttending= user.get("programAttending");
		addCourses(courses);
		
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
