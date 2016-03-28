package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import backend.*;
import user.*;

public class UserController {
	private static UserController instance =null;


	public static String TutorID = "tutor.type";
	public static String StudentID = "student.type";
	public static String StudentTable = "STUDENT";
	public static String TutorTable = "TUTOR";

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

	public UserController(){
		TutorMap = new HashMap<String, Tutor>();
		StudentMap = new HashMap<String, Student>();
		UserCount = 0;
	}

	public boolean createUser(String email, String type, HashMap<String, String> Infomations){
		//check if the infomation input is valid or not
		if (Infomations.keySet().size()<3){
			return false;
		}

		if (TutorID.equals(type))
			return (Boolean) createTutor(email, Infomations);
		else if(StudentID.equals(type))
			return (Boolean) CreateStudent(email, Infomations);
		else
			return false;
	}

	public boolean validateStudent(String email, String password){
		return DatabaseControl.getInstance().validateUser(StudentTable, email, password);
	}

	public boolean validateTutor(String email, String password){
		return DatabaseControl.getInstance().validateUser(TutorTable, email, password);
	}



	public boolean createTutor(String email, HashMap<String, String> Informations){


		try{
		if (TutorMap.containsKey(email) || DatabaseControl.getInstance().checkExistence(TutorTable, email))
			return false;
		Tutor newTutor = new Tutor(Informations);

		TutorMap.put(email, newTutor);
		UserCount +=1;
		return true;
		}catch(Exception e1){
			return false;
		}
	}

	public ArrayList<Tutor> getAllTutors(){
		return DatabaseControl.getInstance().getAllTutors(TutorTable);
	}

	public ArrayList<Student> getAllStudents(){
		return DatabaseControl.getInstance().getAllStudents(StudentTable);
	}


	public Tutor[] getRecommendTutor(String email){
		DatabaseControl dbc = DatabaseControl.getInstance();
		Student targetStudent = dbc.getStudent(StudentTable, email);
		if (targetStudent != null){
			ArrayList<Tutor> alltutors = dbc.getAllTutors(TutorTable);
			if (alltutors.size() > 0){
				//need to be implemented
				Tutor[] tutors= new Tutor[alltutors.size()];
				Tutor[] recommended = getRecommendation(targetStudent, alltutors.toArray(tutors));

				return recommended;
			} else {
				System.err.println("No tutors.");
				return null;
			}
		} else{
			System.err.println("no such suer");
			return null;
		}
	}


	public Tutor[] getRecommendation(Student student, Tutor[] tutors){
		// Student variables
		String student_School = student.getSchoolAttending();
		String student_Program = student.getProgramAttending();
		String student_Course1 = student.getCourse1();
		String student_Course2 = student.getCourse2();
		String student_Course3 = student.getCourse3();
		String student_Course4 = student.getCourse4();
		
		// Tutor variables
		Tutor tutor;
		String tutor_SchoolAttended;
		String tutor_Degree;
		String tutor_ProgramAttended;
		String tutor_SchoolTutoring;
		String tutor_ProgramTutoring;
		String tutor_Course1;
		String tutor_Course2;
		String tutor_Course3;
		String tutor_Course4;
		
		int tutorScore = 0;
		
		// Initialize hashmap of tutors with a score of 0
		HashMap<String, Integer> tutorScores = new HashMap<String, Integer>();
		
		for (int i = 0; i < tutors.length; i++) {
			tutor = tutors[i];
			tutorScores.put(tutor.getEmail(), 0);
		}
		
		// Assign scores to each tutor in hashmap
		for (int i = 0; i < tutors.length; i++) {
			tutor = tutors[i];
			System.out.println(">> Checking tutor: " + tutor.getEmail());
			tutor_SchoolTutoring = tutors[i].getSchool();
			
			// Check student school == school tutor is tutoring at
			if (tutor_SchoolTutoring.equals(student_School)) {
				tutor_ProgramTutoring = tutors[i].getProgram();
				
				// Check student program == program tutor is tutoring for
				if (tutor_ProgramTutoring.equals(student_Program)) {
					tutor_SchoolAttended = tutors[i].getSchool();
				
					// Check student school == tutor school attended
					if (tutor_SchoolAttended.equals(student_School)) {
						tutorScore++;
					}	
					
					tutor_ProgramAttended = tutors[i].getProgram();
					
					// Check student program == tutor program attended
					if (tutor_ProgramAttended.equals(student_Program)) {
						tutorScore++;
					}				
					
					// Check if tutor courses == student courses
					tutor_Course1 = tutors[i].getCourse1();
					tutor_Course2 = tutors[i].getCourse2();
					tutor_Course3 = tutors[i].getCourse3();
					tutor_Course4 = tutors[i].getCourse4();
					List<String> tutor_CourseArray = Arrays.asList(tutor_Course1, tutor_Course2, tutor_Course3, tutor_Course4);
					List<String> student_CourseArray = Arrays.asList(student_Course1, student_Course2, student_Course3, student_Course4);
					String course;
					
					for (int j = 0; j < tutor_CourseArray.size(); j++) {
						if (student_CourseArray.get(j) != null) {
							course = student_CourseArray.get(j);
							
							if (tutor_CourseArray.contains(course)) {
								tutorScore += 3;
							}
						}
					}
					
					// Check tutor's degree
					tutor_Degree = tutors[i].getDegree();
					
					if (tutor_Degree.equals("Ph.D")) {
						tutorScore += 3;
					} else if (tutor_Degree.equals("Master's")) {
						tutorScore += 2;
					} else {
						tutorScore++;
					}
					
					System.out.println(">> " + tutor.getEmail() + " has a score of: " + tutorScore);
					tutorScores.replace(tutor.getEmail(),tutorScore);
					tutorScore = 0;
				} 
			}
		}
		
		Map<String, Integer> sortedTutors = sortByComparator(tutorScores, false);
		
		Tutor[] array = new Tutor[4];
		int index = 0;
		String tutorEmail;
		for (Entry<String, Integer> entry : sortedTutors.entrySet()) {
			tutorEmail = entry.getKey();
			
		    if (index < 4) {
		    	for (int i = 0; i < tutors.length; i++) {
					if (tutorEmail.equals(tutors[i].getEmail())) {
						array[index] = tutors[i];
						index++;
						break;
					}
				}
		    } else {
		    	break;
		    }
		}
			
		System.out.println(">> 1: " + array[0].getEmail());
		System.out.println(">> 2: " + array[1].getEmail());
		System.out.println(">> 3: " + array[2].getEmail());
		System.out.println(">> 4: " + array[3].getEmail());
		
		// Reset variables
		index = 0;
		tutorScores.clear();
		sortedTutors.clear();
		tutorScore = 0;
		
		return array;
	}

	private static Map<String, Integer> sortByComparator(HashMap<String, Integer> unsortMap, final boolean order) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
		
		// Sorting the list based on values
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
		    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		        if (order) {
		            return o1.getValue().compareTo(o2.getValue());
		        } else {
		            return o2.getValue().compareTo(o1.getValue());
		        }
		    }
		});
		
		// Maintaining insertion order with the help of LinkedList
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
		    sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
	
	public boolean CreateStudent(String email, HashMap<String, String> Informations){


		try{
			if (StudentMap.containsKey(email) || DatabaseControl.getInstance().checkExistence(StudentTable, email))
				return false;

			Student newStudent = new Student(Informations);
			StudentMap.put(email, newStudent);
			UserCount += 1;

			return true;
		} catch(Exception e1) {
			return false;
		}
	}

	public Tutor getTutor(String email){
		Tutor targetTutor = TutorMap.get(email);
		if (targetTutor == null){
			 if ((targetTutor = DatabaseControl.getInstance().getTutor(TutorTable, email)) != null)
				 TutorMap.put(email, targetTutor);
		}
		return targetTutor;
	}

	public Student getStudent(String email){
		Student targetStudent = StudentMap.get(email);
		if (targetStudent == null){
				if ((targetStudent = DatabaseControl.getInstance().getStudent(StudentTable, email)) != null)
					StudentMap.put(email, targetStudent);
		}
		return targetStudent;
	}

	public boolean ModifyTutor(String email, HashMap<String, String> Informations){
		Tutor targetTutor = getTutor(email);
		if (targetTutor!= null)
		{
		targetTutor.updateInfo(Informations);
		DatabaseControl.getInstance().updateTutor(TutorTable, targetTutor);
		return true;
		}else{
			System.out.println("tutor does not exits");
			return false;
		}
	}

	public boolean ModifyStudent(String email, HashMap<String, String> Informations){
		Student targetStudent = getStudent(email);


		if (targetStudent != null){
			//this methond takes a complete set Student information, and modify the target Student accordingly
		targetStudent.updateInfo(Informations);
		DatabaseControl.getInstance().updateStudent(StudentTable, targetStudent);
		return true;
		}else{
			System.out.println("student does not exits");
			return false;
		}

	}
}
