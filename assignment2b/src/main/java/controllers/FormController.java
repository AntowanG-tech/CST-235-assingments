package controllers;



import java.sql.SQLException;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;



import business.OrdersBusinessInterface;
import data.OrdersDataService;


@ManagedBean
@ViewScoped

public class FormController {
	@Inject
	OrdersBusinessInterface service;
	
	
	
	public String onLogOff() {
		
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
		// Redirect to a protected page (so we get a full HTTP Request) to get Login Page
		return "LoginPage.xhtml?faces-redirect=true";

	}
	
	public OrdersBusinessInterface getService() {
		
		return service;
	}
	
public String onOrderSubmit() {
		
		//get the product values from the input form
				FacesContext context = FacesContext.getCurrentInstance();
				Order customerOrder = context.getApplication().evaluateExpressionGet(context, "#{order}", Order.class);
				
				//put the user object into the POST request
				//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("product", product);
				
				OrdersDataService service = new OrdersDataService();
				
				try {
					
					service.insertOrder(customerOrder);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return "Response.xhtml";
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

