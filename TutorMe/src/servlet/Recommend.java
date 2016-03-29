package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.Student;
import user.Tutor;

import control.UserController;

import backend.DatabaseControl;

/**
 * Servlet implementation class Recommend
 */
@WebServlet("/Recommend")
public class Recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recommend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String email = request.getParameter("email");
       
		UserController controller= UserController.getInstance();
		
		Tutor[][] orderedTutors;
		
		
		Student student= UserController.StudentMap.get(email);
		HashMap<String, Tutor> tutors=UserController.TutorMap;
		HashMap<Tutor, Integer> values = null;
		Iterator it = tutors.entrySet().iterator();
		
		while(it.hasNext()){
			
		Tutor pair = (Tutor)it.next();	
		int j=0;
		
		if(student.getSchoolAttending()==((Tutor) pair).getSchoolAttended()){
			
			++j;
		}
		
		if(student.getProgramAttending().equals(pair.getProgramAttended())){
			
		
			++j;
			
		}
		
		if(student.getCourse1() == pair.getCourse1() ){
			
			
		++j;
			
		}
		
		if(student.getCourse2() == pair.getCourse2() ){
			
			
			++j;
				
		}
		
         if(student.getCourse3() == pair.getCourse3() ){
			
			
			++j;
				
		}
         
         if(student.getCourse4() == pair.getCourse4() ){
 			
 			
 			++j;
 				
 		}
         
         
         values.put(pair, j);
         
			
	}
        
		Map<Integer, Tutor> mymap= sortByComparator(values, true);
		
		String[] array = ((Set<Entry<Integer, Tutor>>) mymap).toArray(new String[mymap.size()]);
		
		System.out.println("Array Elements:");
	    for (int i = 0; i < array.length; i++)
	    {
	       System.out.println(array[i]);
	    }
	    

	    response.getWriter().println(Arrays.toString(array));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	
	 private static Map<Integer, Tutor> sortByComparator(Map<Tutor, Integer> unsortMap, final boolean order)
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
	        Map<Integer, Tutor> sortedMap = new LinkedHashMap<Integer, Tutor>();
	        for (Entry<Tutor, Integer> entry : list)
	        {
	            sortedMap.put(entry.getValue(), entry.getKey());
	        }

	        return sortedMap;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
