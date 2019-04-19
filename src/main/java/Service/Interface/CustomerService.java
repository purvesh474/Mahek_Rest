package Service.Interface;

import java.util.ArrayList;
import java.util.Map;

import Dao.Customer;

public interface CustomerService {

	public Customer getCustomerById(int id);
	public ArrayList<Customer> getAllCustomer();
	public Customer getCustomerByUsername(String username);
	public int deleteCustomerById(int id);
	public int insertCustomerDetails(Customer cus);
	public int UpdateCustomer(int id, Customer cus);
	public int changePassword(Map<String, String> map);
	
	public ArrayList<Customer> getCustomerByUsertype(String usertype);
}
