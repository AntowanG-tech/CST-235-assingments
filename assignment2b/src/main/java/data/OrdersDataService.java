package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import beans.Order;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@LocalBean
public class OrdersDataService implements DataAccessInterface {

    /**
     * Default constructor. 
     */
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Order> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost:3306/testdatabase";
		String user = "root";
		String password = "root";
		
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Order> orders = new ArrayList<>();
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("  ////// Connection is successful "+ dbURL + " user: " + user + " password: " + password + " ///////// ");
			
			// create sql statement
			stmt = c.createStatement();
			
			//execute statement
			rs = stmt.executeQuery("SELECT * FROM `orders`");
			
			//process the rows in the result set
			while(rs.next()) {
				int id = rs.getInt("id");
				String productName = rs.getString("product_name");
				String orderNo = rs.getString("order_no");
				float price = rs.getFloat("price");
				int quantity = rs.getInt("quantity");
				
				Order newOrder = new Order(rs.getInt("id"), rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity"));
		        orders.add(newOrder);
		        
		        System.out.println("ID: " + id + ", Order Nubmer: " + orderNo + ", Product Name:  " + productName + ", Price: " + price + ", Quantity: " + quantity + ".");
				}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("### ERROR --- connecting to database: ");
			e.printStackTrace();
			System.out.println("### END ###");
		} finally {
			//close the connection to db
			stmt.close();
			c.close();
		}
		
		return orders;
		
	
	
	}
	
public int insertOrder(Order customerOrder) throws SQLException {
		

		String dbURL = "jdbc:mysql://localhost:3306/testdatabase";
		String user = "root";
		String password = "root";
		
		Connection c = null;
		PreparedStatement st = null;
		int rs = 0;
		
		//String SQL = "INSERT INTO testdatabase.orders(order_no, product_name, price, quantity) VALUES (?,?,?,?)";
		
		
		try {
			c = DriverManager.getConnection(dbURL, user, password);
			System.out.println("  ////// Connection is successful "+ dbURL + " user: " + user + " password: " + password + " ///////// ");
			
			// create sql statement
			//Statement stmt = c.createStatement();
			st = c.prepareStatement("INSERT INTO testdatabase.orders(id, order_no, product_name, price, quantity) VALUES (?, ?, ?, ?, ?)");
			st.setInt(1, customerOrder.getId());
			st.setString(2,  customerOrder.getOrderNumber());
			st.setString(3,  customerOrder.getProductName());
			st.setFloat(4,  customerOrder.getPrice());
			st.setInt(5,  customerOrder.getQuantity());
			
			//execute statement
			//stmt.executeUpdate(SQL);
			rs = st.executeUpdate();
			
			
		} catch (SQLException e) {
			
			System.out.println("### ERROR --- connecting to database: ");
			e.printStackTrace();
			System.out.println("### END ###");
		} finally {
			//close the connection to db
			st.close();
			c.close();
		}
		
	return rs;
		
	}
	}

    

