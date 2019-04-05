package Service.Interface;

import java.util.ArrayList;

import Dao.CustomerType;

public interface CustomerTypeService {
	
	
	public CustomerType getCustomerTypeByID(int id);
	public int AddCustomerType(CustomerType cusType);
	public int updateCustomerTypeById(int id,CustomerType ctype);
	public CustomerType getCustomerUserTypeByTypeName(String name);
	public int updatemargin(String margin,String name);

	public ArrayList<CustomerType> getAllCType();
}
