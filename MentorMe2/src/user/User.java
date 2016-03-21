package user;

import java.util.HashMap;

public abstract class User {

	

	
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	
	
	public User(HashMap<String, String> user){
		
		this.firstName=user.get("firstName");
		this.lastName=  user.get("lastName");
		this.email= user.get("email");
		this.password= user.get("password");
		
		
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLast() {
		return lastName;
	}
	public void setLast(String last) {
		this.lastName = last;
	}
	
	public String getFirst() {
		return firstName;
	}
	public void setFirst(String first) {
		this.firstName = first;
	}
	
	
	abstract void updateInfo(HashMap<String, String> user);
	
	
}
