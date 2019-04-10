package Controller;

import java.util.ArrayList;
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

import Dao.Banner;
import Dao.Customer;
import Service.Interface.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	public BannerService bannerServ;

	@RequestMapping("/id/{id}")
	public ResponseEntity<Map<String, Object>> getBannerById(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Banner banner = null;
		boolean flag = false;
		try {
			banner = bannerServ.getBannerById(id);
			if (banner != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", banner);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Banner Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> AddBanner(@RequestBody Banner bs) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = bannerServ.insert(bs);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Banner Added Successfully!");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Failed to Add Banner!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>>	UpdateBannerByID(@PathVariable("id") int id ,@RequestBody Banner bs){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = bannerServ.updateBannerById(id, bs);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Banner Updated Successfully!");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Failed to Update Banner!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping("/all")
	public ResponseEntity<Map<String , Object>> getAllBanner(){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<Banner> listBanner=null;
		try {
			listBanner=bannerServ.getAllBanner();
			if(listBanner.size()>0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listBanner);
			}
			else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "No Banner Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteBannerbyID(@PathVariable("id") int id){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result=0;
		try {
			result=bannerServ.deleteBannerbyId(id);
			if(result>0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Banner Deleted!");
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Banner Not Deleted!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 
}
