package beans;

import javax.faces.bean.*;

@ManagedBean
@ViewScoped
public class User {
	String firstName;
	String lastName;
	
	public User () {
		this.firstName = "Antowan";
		this.lastName = "Graham";
		
	}
	
	public User (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
