package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.Customer;
import Service.Interface.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	public CustomerService cusService;
	
	@RequestMapping("/index")
	public String getIndex() {
		return "Hello Index!";
	}
	@RequestMapping("/id/{id}")
	public ResponseEntity<Map<String, Object>> getCustomerById(@PathVariable("id") int id) {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		Customer cus=null;
		boolean flag=false;
		List returnList=new ArrayList<>();
		try {
		cus=cusService.getCustomerById(id);
		if(cus!=null) {
			flag=true;
			returnMap.put("Status", flag);
			returnMap.put("Details", cus);
			//returnList.add(cus);	
		}
		return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	
	}
	
	@RequestMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllCustomer(){
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		try {
		ArrayList<Customer> cus=cusService.getAllCustomer();
		if(cus.size()>0) {
			flag=true;
			returnMap.put("Status",flag);
			returnMap.put("Details", cus);
		}
		return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@RequestMapping("/username/{username}")
	public ResponseEntity<Map<String, Object>> getCustomerByUsername(@PathVariable("username") String username ) {
		
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		try {
			Customer cus=cusService.getCustomerByUsername(username);
			if(cus!=null) {
			flag=true;
			returnMap.put("Status",	flag);
			returnMap.put("Details", cus);
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> deleteCustomerById(@PathVariable("id") int id) {
		
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		try {
		int result= cusService.deleteCustomerById(id);
		if(result>0) {
			flag=true;
			returnMap.put("Status",flag);
			returnMap.put("UserID", id);	
		}
		return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping("/check/{username}")
	public ResponseEntity<Map<String, Object>> IsCustomerExistOrNot(@PathVariable("username") String username){
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		try {
		Customer cus=cusService.getCustomerByUsername(username);
		if(cus!=null) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Username Already Exist!");
		}
		return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			flag=true;
			returnMap.put("Status", flag);
			returnMap.put("Message", "Username is Available");
			
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}
	}
	
	private Customer GenerateUsernameAndPassword(Customer customer) {
		String firstName="";
		String lastName="";
		StringBuilder Username=new StringBuilder();
		do {
			if(customer.getFirstname()!=null && customer.getLastname()!=null) {
				firstName=customer.getFirstname();
				lastName=customer.getLastname();
				if(firstName.length()<3) {
					Username.append(firstName.substring(0, firstName.length()));
				}else {
					Username.append((String) firstName.substring(0,3));
				}
				if(lastName.length()<3) {
					Username.append(lastName.substring(0, lastName.length()));
				}else {
					Username.append(lastName.substring(0,3));
				}
				Random random = new Random();

				// generate a random integer from 0 to 899, then add 100
				int x = random.nextInt(900) + 100;
				Username.append(x);
			}
		}while (cusService.getCustomerByUsername(Username.toString())!=null);
		customer.setUsername(Username.toString().toLowerCase());
		customer.setPassword(Username.toString().toLowerCase());
	
	return customer;
		
		
}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> RegisterCustomer(@RequestBody Customer cus) {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		
		Customer customer=GenerateUsernameAndPassword(cus);
		boolean flag=false;
		try {
		int result=cusService.insertCustomerDetails(customer);
		if(result>0) {
			flag=true;
			returnMap.put("Status", flag);
			returnMap.put("UserName", customer.getUsername());
			
		}
		return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> UpdateCustomer(@PathVariable("id")int id,@RequestBody Customer cus){
		Map<String, Object> returnMap=new HashMap<String, Object>();
		int result=0;
		boolean flag=false;
		try {
			result= cusService.UpdateCustomer(id, cus);
			if(result>0) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("UserID", id);
			}else {
				returnMap.put("Status", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch(Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		
		
	}
}
		
