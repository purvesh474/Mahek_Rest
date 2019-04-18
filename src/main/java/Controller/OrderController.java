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

import Dao.Order;
import Service.Interface.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	public OrderService orderService;

	@RequestMapping("/orderbyid/{id}")
	public ResponseEntity<Map<String, Object>> getOrderByOrderId(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		Order orderdet = null;
		try {
			orderdet = orderService.getOrderById(id);
			if (orderdet != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", orderdet);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/orderbyuser/{id}")
	public ResponseEntity<Map<String, Object>> getOrderByUserID(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		Order orderdet = null;
		try {
			orderdet = orderService.getOrderByUserID(id);
			if (orderdet != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", orderdet);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllOrder() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<Order> listOrder = null;
		try {
			listOrder = orderService.getAllOrder();
			if (listOrder.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listOrder);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addOrder(@RequestBody Order order) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = orderService.addOrder(order);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Placed Successfully!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/viewbygrouporderno")
	public ResponseEntity<Map<String, Object>> getOrderByOrderNO() {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<Order> listOrder = null;
		try {
			listOrder = orderService.getAllOrderByOrderNumber();
			if (listOrder.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listOrder);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");

			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/orderno/{ordernumber}")
	public ResponseEntity<Map<String, Object>> viewOrderbyOrdernumber(@PathVariable("ordernumber") String ordernumber) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<Order> listOrder = null;
		try {
			listOrder = orderService.getOrderBYOrderNO(ordernumber);
			if (listOrder.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listOrder);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");

			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping("/orderbyuserid/{userid}")
	public ResponseEntity<Map<String, Object>> viewOrderBYuserid(@PathVariable("userid") int userid){
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<Order> listOrder = null;
		try {
			listOrder=orderService.getOrderByOrdernoAndUserid(userid);
			if (listOrder.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listOrder);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Order Not Found!");

			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
