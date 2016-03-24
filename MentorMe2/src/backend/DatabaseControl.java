package backend;

import java.sql.*;
import java.util.Set;

import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;


//import admin.ServerProperties;
import user.Student;


public class DatabaseControl
 {
	
	private String dataBaseUrl;
	private static DatabaseControl instance = null;
	
	//default setting
	private String databaseHost;// = ServerProperties.domain;
	private int port;// = ServerProperties.port;
	private String databaseName;// = ServerProperties.mainDataBase;
	private String user;// = ServerProperties.userName;
	private String password;// = ServerProperties.password;
	private String url;// = "myurl";
	
	public static DatabaseControl getInstance() {
	      if(instance == null) {
	         instance = new DatabaseControl();
	      }
	      return instance;
	}
	
	
	private DatabaseControl(){
		
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		if (VCAP_SERVICES != null) {
			// parse the VCAP JSON structure
			BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
			String thekey = null;
			Set<String> keys = obj.keySet();
			// Look for the VCAP key that holds the SQLDB information
			for (String eachkey : keys) {
				// Just in case the service name gets changed to lower case in the future, use toUpperCase
				if (eachkey.toUpperCase().contains("SQLDB")) {
					thekey = eachkey;
				}
			}
			if (thekey == null) {
				return;
			}
			BasicDBList list = (BasicDBList) obj.get(thekey);
			obj = (BasicDBObject) list.get("0");
			// parse all the credentials from the vcap env variable
			obj = (BasicDBObject) obj.get("credentials");
			databaseHost = (String) obj.get("host");
			databaseName = (String) obj.get("db");
			port = (int)obj.get("port");
			user = (String) obj.get("username");
			password = (String) obj.get("password");
			url = (String) obj.get("jdbcurl");
		}
		
	}
	
	
	
	public  Connection getConnection() throws ClassNotFoundException, SQLException{
		//loading drivers for mysql
		Connection con = null;
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			 con = DriverManager.getConnection(url, user ,password);
			return con;
		}catch(Exception e1){
			  e1.printStackTrace();
			  /**
			  Class.forName("com.mysql.jdbc.Driver");
			  return DriverManager.getConnection
                ("jdbc:mysql://" + ServerProperties.domain
                		+ ":"+ServerProperties.port + "/"+ ServerProperties.mainDataBase
                		,ServerProperties.userName,ServerProperties.password);
                		*/
		}
		return con;
		
		
		
		 //creating connection with the database
		
		
                		
		
	}
	
	
     public  boolean checkUser(String name,String pass) 
     {
      boolean st =false;
      try{


 	 //creating connection with the database 
         Connection con= getConnection();
         PreparedStatement ps =con.prepareStatement
                             ("select * from Users where name=? and pass=?");
         ps.setString(1, name);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
     
     public  boolean checkExistence(String table, String email) 
     {
      boolean st =false;
      try{

    	 Connection con= getConnection();
    	 String query = "SELECT * from $tableName where EMAIL = ?";
         PreparedStatement ps =con.prepareStatement(
        		 query.replace("$tableName", table));
         ps.setString(1, email);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
     public void updateStudent(String table, Student student){
    	 try {
			Connection con= getConnection();
			//if key exists
			if (checkExistence(table, student.getEmail())){
				String query = "UPDATE $tableName SET"
						+ "COURSE_ONE=?, COURSE_TWO=?, COURSE_THREE=?,"
						+ "COURSE_FOUR=?, FIRSTNAME=?, LASTNAME =?,"
						+ "PASSWORD=?, PROGRAM=?, SCHOOL=?  WHERE EMAIL = ?";
				PreparedStatement ps =con.prepareStatement(
		        		 query.replace("$tableName", table));
				ps.setString(1, student.getCourse1());
				ps.setString(2, student.getCourse2());
				ps.setString(3, student.getCourse3());
				ps.setString(4, student.getCourse4());
				ps.setString(5, student.getFirst());
				ps.setString(6, student.getLast());
				ps.setString(7, student.getPassword());
				ps.setString(8, student.getProgramAttending());
				ps.setString(9, student.getSchoolAttending());
				ps.setString(10, student.getEmail());
				ps.executeUpdate();
			}else{
				String query = "INSERT INTO $tableName "
						+ "(COURSE_ONE, COURSE_TWO, COURSE_THREE,"
						+ " COURSE_FOUR, FIRSTNAME, LASTNAME,"
						+ "PASSWORD, PROGRAM, SCHOOL, EMAIL) VALUES"
						+ "(?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps =con.prepareStatement(
		        		 query.replace("$tableName", table));
				ps.setString(1, student.getCourse1());
				ps.setString(2, student.getCourse2());
				ps.setString(3, student.getCourse3());
				ps.setString(4, student.getCourse4());
				ps.setString(5, student.getFirst());
				ps.setString(6, student.getLast());
				ps.setString(7, student.getPassword());
				ps.setString(8, student.getProgramAttending());
				ps.setString(9, student.getSchoolAttending());
				ps.setString(10, student.getEmail());
				String result = ps.toString();
				ps.executeUpdate();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public  ResultSet GetAllUsers() 
     {
      try{

    	 Connection con= instance.getConnection();
         PreparedStatement ps =con.prepareStatement
                             ("select * from Users");
         ResultSet rs =ps.executeQuery();
         return rs;
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return null;                 
  }   
     
     
}