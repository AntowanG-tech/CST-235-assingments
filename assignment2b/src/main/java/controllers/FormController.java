package controllers;



import java.sql.SQLException;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import beans.User;

import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped

public class FormController {
	@Inject
	OrdersBusinessInterface service;
	
	
	
	public String onSubmit(User user) throws SQLException {
		
		//get the user value from the input form
		FacesContext ctx = FacesContext.getCurrentInstance();
		//Order order = ctx.getApplication().evaluateExpressionGet(ctx, "#{order}", Order.class);
		
	service.getOrders();	
		
		
		//puts user object into post request
		ctx.getExternalContext().getRequestMap().put("user", user);
		
		
		//implementation of the services test method
		service.test();
		
		
		
		
		
		//return the next page
		return "Response.xhtml";
	}
	
	public OrdersBusinessInterface getService() {
		
		return service;
	}
	
	
	
	/**private void insertOrder() throws SQLException {
		

		String dbURL = "jdbc:mysql://localhost:3306/testdatabase";
		String user = "root";
		String password = "root";
		
		Connection c = null;
		String SQL = "INSERT INTO testdatabase.orders(order_no, product_name, price, quantity) VALUES ('001122334455', 'This was inserted new', 25.00, 100)";
		
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("  ////// Connection is successful "+ dbURL + " user: " + user + " password: " + password + " ///////// ");
			
			// create sql statement
			Statement stmt = c.createStatement();
			
			//execute statement
			stmt.executeUpdate(SQL);
			
			
			
		} catch (SQLException e) {
			
			System.out.println("### ERROR --- connecting to database: ");
			e.printStackTrace();
			System.out.println("### END ###");
		} finally {
			//close the connection to db
			
			c.close();
		}
		
	
		
	}*/

}

