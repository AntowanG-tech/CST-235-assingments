package business;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Order;

@RequestScoped
@Path("/orders")
public class OrdersRestService {

	@Inject
	OrdersBusinessInterface service;
	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getOrdersAsJson() throws SQLException {
		List<Order> resultAsJSON = service.getOrders();
		return resultAsJSON;
		
	}
	
	@GET
	@Path("/getxml")
	@Produces(MediaType.APPLICATION_XML)
	public Order[] getOrdersAsXml() throws SQLException {
		 List<Order> orderXmlArray =  service.getOrders();
		Order[] orderXml = new Order[orderXmlArray.size()];
	
		for (int i = 0; i < orderXmlArray.size(); ++i) {
			orderXml[i] = orderXmlArray.get(i);
		}
		
		return orderXml;
		
		
	}
	
	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public void postOrdersAsJson() {
		
	}
	
}
