package beans;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.OrdersBusinessInterface;

@ManagedBean
@ViewScoped
public class Orders {
	public List<Order> orders = new ArrayList<Order>();
	
	@Inject
	OrdersBusinessInterface service;
	
	public Orders() {
		
	}
	
	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void init() throws SQLException {
		orders = service.getOrders();
	}
	
	

}
