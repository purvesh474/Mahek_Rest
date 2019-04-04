package Service.Interface;

import java.util.ArrayList;
import java.util.Map;

import Dao.Customer;

public interface LoginService {

	public ArrayList<Customer> checkLogin(Map<String, String> credential);
	//public ArrayList<Customer> checkAdminLogin(Map<String, String> credential);
	
	
}
