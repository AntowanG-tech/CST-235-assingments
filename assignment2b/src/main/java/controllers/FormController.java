package controllers;

import javax.ejb.EJB;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import beans.User;
import business.MyTimerService;
import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped

public class FormController {
	@Inject
	OrdersBusinessInterface service;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit(User user) {
		
		//get the user value from the input form
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		
		
		
		//puts user object into post request
		ctx.getExternalContext().getRequestMap().put("user", user);
		
		
		//implementation of the services test method
		service.test();
		
		//Start a timer when login is clicked
		timer.setTimer(5000);
		
		//return the next page
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		
		return service;
	}
	
	

}
