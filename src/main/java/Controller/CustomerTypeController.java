package Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.Customer;
import Dao.CustomerType;
import Service.Interface.CustomerTypeService;

@RestController
@RequestMapping("/ctype")
public class CustomerTypeController {

	@Autowired
	public CustomerTypeService cusTypeServ;

	@RequestMapping("/id/{id}")
	public ResponseEntity<Map<String, Object>> getCTypeById(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		CustomerType ctype = null;
		try {
			ctype = cusTypeServ.getCustomerTypeByID(id);
			if (ctype != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", ctype);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addCusType(@RequestBody CustomerType ctype) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = cusTypeServ.AddCustomerType(ctype);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Customertype", ctype.getUsertype());
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update/margin/{usertypeName}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateMargin(@PathVariable("usertypeName") String usertypename,
			@RequestBody String margin) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = cusTypeServ.updatemargin(margin, usertypename);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("UserTypeName", usertypename);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update/type/{id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> updateCustomerTypeById(@PathVariable("id") int id,
			@RequestBody CustomerType ctype) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = cusTypeServ.updateCustomerTypeById(id, ctype);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("UserType", ctype.getUsertype());
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "UserType not Found");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping("/typename/{usertypename}")
	public ResponseEntity<Map<String, Object>> getCustomerUserTypeByTypeName(@PathVariable("usertypename") String usertypename){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		CustomerType custype=null;
		boolean flag = false;
		try {
			custype=cusTypeServ.getCustomerUserTypeByTypeName(usertypename);
			if(custype!=null) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Details", custype);	
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		}catch (Exception e) {
			//System.out.println(e);
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
