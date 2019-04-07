package Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.Interface.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	
	@Autowired
	public DashboardService dahsService;
	
	@RequestMapping("/customercount/{usertype}")
	public ResponseEntity<Map<String, Object>> getUsertypeCount(@PathVariable("usertype") String usertype)
	{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int count=0;
		try {
			count=dahsService.getUserTypeCount(usertype);
			if(count>0) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Count", count);
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message","This type of user not found");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@RequestMapping("/productcount")
	public ResponseEntity<Map<String, Object>> getTotalProductCount(){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int count=0;
		try {
			count=dahsService.getTotalProductCount();
			if(count>0) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Count", count);
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message","Product Not Found");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/categorywise/{id}")
	public ResponseEntity<Map<String, Object>> getProductByCategoryID(@PathVariable("id") int id){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int count=0;
		try {
			count=dahsService.getProductCountByCategoryid(id);
			if(count>0) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Count", count);
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message","Product Not Found for this category");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
