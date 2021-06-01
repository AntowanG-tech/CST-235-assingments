package controllers;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.Orders;
import beans.User;

@ManagedBean
@ViewScoped
public class FormController {
	
	
	public String onSubmit(User user) {
		
		//get the user value from the input form
		FacesContext ctx = FacesContext.getCurrentInstance();
		
		//User user = ctx.getApplication().evaluateExpressionGet(ctx, "#{user}", User.class);
		Orders customerOrders = new Orders();
		
		//puts user object into post request
		ctx.getExternalContext().getRequestMap().put("user", user);
		ctx.getExternalContext().getRequestMap().put("orders", customerOrders.getOrders());
		
		//return the next page
		return "Response.xhtml";
	}
	
	

}
