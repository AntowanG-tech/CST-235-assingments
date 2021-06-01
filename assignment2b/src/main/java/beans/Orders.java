package beans;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	public List<Order> orderList;
	
	public Orders() {
		this.orderList = Arrays.asList(new Order("1", "Snickers", 2.50f, 2));
	}
	
	public Orders(List<Order> orders) {
		this.orderList = orders;
	}

	public List<Order> getOrders() {
		return orderList;
	}

	public void setOrders(List<Order> orders) {
		this.orderList = orders;
	}
	
	

}
