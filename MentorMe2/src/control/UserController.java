package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

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

	private UserController(){
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
				return getRecommendation(targetStudent, alltutors.toArray(tutors));
			}
		}
		else{
			System.err.println("no such suer");
		}
	}


	public Tutor[] getRecommendation(Student student, Tutor[] tutors){


		HashMap<Tutor, Integer> values = new HashMap<Tutor, Integer>();

		for(int i=0;i<tutors.length;++i){

			int j=0;

			if(student.getSchool().equals(tutors[i].getSchool())){

				++j;


			if(student.getProgram().equals(tutors[i].getProgram())){


				++j;

			if(student.getCourse1().equals(tutors[i].getCourse2()) || student.getCourse1().equals(tutors[i].getCourse3()) || student.getCourse1().equals(tutors[i].getCourse4())){


			++j;

			}

			if(student.getCourse2().equals(tutors[i].getCourse1()) || student.getCourse2().equals(tutors[i].getCourse3()) || student.getCourse2().equals(tutors[i].getCourse4())){


				++j;

			}

	    if(student.getCourse3().equals(tutors[i].getCourse1()) || student.getCourse3().equals(tutors[i].getCourse2()) || student.getCourse3().equals(tutors[i].getCourse4()) ){


				++j;

			}

	    if(student.getCourse4().equals(tutors[i].getCourse1()) || student.getCourse4().equals(tutors[i].getCourse2()) || student.getCourse3().equals(tutors[i].getCourse3())  ){


	 			++j;

	 		}


      if(tutor[i].getDegree().equals("Bachelor's")){
				++j;
			}else if(tutor[i].getDegree().equals("Master's")){

        j=j+2;

			}else if(tutor[i].getDegree().equals("Ph.D")){

				j=j+3;
			}


}

}

	         values.put(tutors[i], j);
		}


	/*	<li><a href="#">Bachelor's</a></li>
		<li><a href="#">Master's</a></li>
		<li><a href="#">Ph.D</a></li> */

	  Map<Tutor, Integer> mymap= sortByComparator(values, false);

		List<Tutor> keyList = new ArrayList<Tutor>(mymap.keySet());
		Tutor[] array = keyList.toArray(new Tutor[keyList.size()]);

		System.out.println("Array Elements:");
	  for (int i = 0; i < array.length; i++)
	    {
	       System.out.println(array[i].getFirst());
	    }


		return array;

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

	private static Map<Tutor, Integer> sortByComparator(Map<Tutor, Integer> unsortMap, final boolean order)
	 {

			 List<Entry<Tutor, Integer>> list = new LinkedList<Entry<Tutor, Integer>>(unsortMap.entrySet());

			 // Sorting the list based on values
			 Collections.sort(list, new Comparator<Entry<Tutor, Integer>>()
			 {
					 public int compare(Entry<Tutor, Integer> o1,
									 Entry<Tutor, Integer> o2)
					 {
							 if (order)
							 {
									 return o1.getValue().compareTo(o2.getValue());
							 }
							 else
							 {
									 return o2.getValue().compareTo(o1.getValue());

							 }
					 }
			 });

			 // Maintaining insertion order with the help of LinkedList
			 Map<Tutor, Integer> sortedMap = new LinkedHashMap<Tutor, Integer>();
			 for (Entry<Tutor, Integer> entry : list)
			 {
					 sortedMap.put(entry.getKey(), entry.getValue());
			 }

			 return sortedMap;
	 }








}
