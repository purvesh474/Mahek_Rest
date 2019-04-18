package Service.Interface;

import java.util.ArrayList;

import Dao.Order;

public interface OrderService {

	public Order getOrderById(int id);
	public ArrayList<Order> getAllOrder();
	public Order getOrderByUserID(int userid);
	public int addOrder(Order order);
	public ArrayList<Order> getAllOrderByOrderNumber();
 	public ArrayList<Order> getOrderBYOrderNO(String ordernumber);
 	public ArrayList<Order> getOrderByOrdernoAndUserid(int userid);
}
