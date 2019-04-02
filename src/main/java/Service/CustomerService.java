package Service;

import java.util.ArrayList;

import Dao.Customer;

public interface CustomerService {

	public Customer getCustomerById(int id);
	public ArrayList<Customer> getAllCustomer();
	public Customer getCustomerByUsername(String username);
	public int deleteCustomerById(int id);
	public int insertCustomerDetails(Customer cus);
	
}
