package Service.Interface;

import java.util.ArrayList;

import Dao.Order;

public interface OrderService {

	public Order getOrderById(int id);
	public ArrayList<Order> getAllOrder();
	public Order getOrderByUserID(int userid);
	public int addOrder(Order order);
	
}
