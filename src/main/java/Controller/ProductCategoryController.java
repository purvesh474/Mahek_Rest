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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Dao.ProductCategory;
import Service.Interface.ProductCategoryService;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

	@Autowired
	public ProductCategoryService categoryserv;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addCategory(@RequestBody ProductCategory category) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = categoryserv.AddCategory(category);
			System.out.println("Result is " + result);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("CategoryName", category.getCategoryname());
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

	@RequestMapping("/id/{id}")
	public ResponseEntity<Map<String, Object>> getProductCategoryById(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ProductCategory categoryObj = categoryserv.getCategoryById(id);
			if (categoryObj != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", categoryObj);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> UpdateCategoryById(@PathVariable("id") int id,
			@RequestBody ProductCategory category) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			int result = categoryserv.updateCategory(id, category);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("CategoryName", category.getCategoryname());
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Something Went Wrong!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping("/search/{categoryname}")
	public ResponseEntity<Map<String, Object>> searchCategory(@PathVariable("categoryname") String categoryName){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<ProductCategory> categoryList=categoryserv.searchCategoryByName(categoryName);
			if(categoryList.size()>0 && categoryList!=null) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Details",categoryList);
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "No Category found!");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllCategory(){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<ProductCategory> listCat=categoryserv.getAllCategory();
			if(listCat.size()>0 && !listCat.isEmpty()) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("Details",listCat);
			}else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Category NOt Found!");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> deleteCategoryById(@PathVariable("id")int id){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result=0;
		try {
			result=categoryserv.deleteCategoryById(id);
			if(result>0) {
				flag=true;
				returnMap.put("Status", flag);
				returnMap.put("categoryid", id);
			}
			else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Category Not Found!");
			}
			return new ResponseEntity(returnMap,HttpStatus.OK);
		}catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

}
