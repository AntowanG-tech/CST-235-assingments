package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;
import beans.Orders;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor. 
     */
    public OrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	
    	orders.add(new Order("00001", "dummy1", 1.00f, 1));
    	orders.add(new Order("00002", "dummy2", 2.00f, 2));
    	orders.add(new Order("00003", "dummy3", 3.00f, 3));
    	orders.add(new Order("00004", "dummy4", 4.00f, 4));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello from the OrdersBusinessService");
    }

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrders(List<Orders> orders) {
		// TODO Auto-generated method stub
		
	}

}
