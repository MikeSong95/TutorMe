package backend;

import java.util.HashMap;

import backend.DatabaseControl;

public class UserController {
	private static UserController instance =null;
	
	
	public static String TutorID = "tutor.type";
	public static String StudentID = "student.type";
	public static String StudentTable = "Student";
	public static String TutorTable = "Tutor";
	
	//maps to keep track of all local users in jvm
	public static HashMap<String, Tutor> TutorMap;
	public static HashMap<String, Student> StudentMap;
	
	//if user counts exceeds LocalUserThreshHold, push local users info to database and clear local vm storage
	public static int UserCount;
	public static int LocalUserThreshHold =10;
	
	
	public static UserController getInstance() {
	      if(instance == null) {
	         instance = new UserController();
	      }
	      return instance;
	}
	
	private UserController(){
		TutorMap = new HashMap<String, Tutor>();
		StudentMap = new HashMap<String, StudentMap>();
		UserCount =0;
	}
	
	public boolean createUser(String email, String type, HashMap<String, String> Infomations){
		//check if the infomation input is valid or not
		if (Infomations.keySet().size()<3){
			return false;
		}
		
		if (TutorID.equals(type))
			return (Boolean)CreateTutor(email, Infomations);
		else if(StudentID.equals(type))
			return (Boolean) CreateStudent(email, Infomations);
	}
	
	public boolean createTutor(String email, HashMap<String, String> Informations){
		try{
		if (TutorMap.containsKey(email) || DatabaseControl.getInstance().checkExistence(TutorTable, email))
			return false;
		Tutor newTutor = new Tutor(Informations);
		TutorMap.put(email, newTutor);
		UserCount +=1;
		}catch(Exception e1){
			return false;
		}
	}
	
	public boolean CreateStudent(String email, HashMap<String, String> Informations){
		try{
		if (StudentMap.containsKey(email) || DatabaseControl.getInstance().checkExistence(StudentTable, email))
			return false;
		Student newStudent = new Student(Informations);
		StudentMap.put(email, newStudent);
		UserCount += 1;
		}catch(Exception e1){
			return false;
		}
	}
	
	public void ModifyTutor(String email, HashMap<String, String> Informations){
		Tutor targetTutor = TutorMap.get(email);
		if (targetTutor == null){
				targetTutor = new Tutor(Informations);
		}
		else{
			//this methond takes a complete set tutor information, and modify the target tutor accordingly
			targetTutor.modify(Informations);
		}
		
	}
	
	public ModifyStudent(String email, HashMap<String, String> Informations){
		Student targetTutor = StudentMap.get(email);
		if (targetStudent == null){
				targetStudent = new Student(Informations);
		}
		else{
			//this methond takes a complete set Student information, and modify the target Student accordingly
			targetStudent.modify(Informations);
		}
		
	}
	
	
	
	
}