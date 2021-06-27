package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    
	@NotNull
	@Size(min=5, max=15)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName) {
		this.firstName = firstName;
	}

	@NotNull
	@Size(min=5, max=15)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//username: gcu
	//password: lopes
	@PostConstruct
	public void init() {
		
		// Get the logged in Principle
		Principal principle= FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if(principle == null)
			{
				setFirstName("Unknown");
				setLastName("");
			}
			else
			{
				setFirstName(principle.getName());
				setLastName("");
			}

	}
	
	

}
