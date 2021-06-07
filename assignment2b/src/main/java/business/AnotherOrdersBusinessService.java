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
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrdersBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {
	List<Order> orders = new ArrayList<Order>();

    /**
     * Default constructor. 
     */
    public AnotherOrdersBusinessService() {
        // TODO Auto-generated constructor stub
    	
    	orders.add(new Order("000011", "thing1", 1.00f, 1));
    	orders.add(new Order("000012", "thing2", 2.00f, 2));
    	orders.add(new Order("000013", "thing3", 3.00f, 3));
    	orders.add(new Order("000014", "thing4", 4.00f, 4));
    }

	/**
     * @see OrdersBusinessInterface#test()
     */
    public void test() {
        // TODO Auto-generated method stub
    	System.out.println("Hello from the AnotherBusinessService");
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
