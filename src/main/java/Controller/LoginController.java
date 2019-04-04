package Controller;

import java.awt.PageAttributes.MediaType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

import Dao.Customer;
import Service.Interface.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	public LoginService loginService;

	@RequestMapping(value = "/type", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody Map<String, String> userDetails) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		Customer cus=new Customer();
		try {
			ArrayList<Customer> customer = loginService.checkLogin(userDetails);
			
			if (!customer.isEmpty() && customer.size() == 1) {
				flag = true;
				cus=customer.get(0);
				cus.setPassword("");
				ArrayList<Object> a  = new ArrayList<Object>();
				
				returnMap.put("Status", flag);
				returnMap.put("Details", cus);
				//returnMap.put("Message", "User Found Successfully!");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "User Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
