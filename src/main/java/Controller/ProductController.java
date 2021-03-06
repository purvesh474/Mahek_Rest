package Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.AmqpContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Dao.Customer;
import Dao.Product;
import Dao.ProductCategory;
import Service.Interface.ProductCategoryService;
import Service.Interface.ProductService;;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService proService;

	@Autowired
	private ProductCategoryService ps;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> addProductDetails(@RequestBody Product product) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		ProductCategory pc = ps.getCategoryById(product.getCategoryid());
		product.setCategoryname(pc.getCategoryname());
		boolean flag = false;
		try {
			int result = proService.addProductDetails(product);

			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("ProductCode", product.getProductcode());
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/id/{id}")
	public ResponseEntity<Map<String, Object>> getProductByID(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			Product prd = proService.getProductByID(id);
			if (prd != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", prd);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/all")
	public ResponseEntity<Map<String, Object>> getAllProduct() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<Product> listProduct = proService.getAllProduct();
			if (listProduct != null && listProduct.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listProduct);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/all/active")
	public ResponseEntity<Map<String, Object>> getAllActiveProduct() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<Product> listProduct = proService.getAllActiveProduct();
			if (listProduct != null && listProduct.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listProduct);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/search/{searchName}")
	public ResponseEntity<Map<String, Object>> searchProductByName(@PathVariable("searchName") String searchname) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<Product> list = proService.searchProductByName(searchname);
			if (list.size() > 0 && !list.isEmpty()) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", list);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/prd/{productcode}")
	public ResponseEntity<Map<String, Object>> getProductByProductCode(
			@PathVariable("productcode") String productcode) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			Product prd = proService.getProductByProductCode(productcode);
			if (prd != null) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", prd);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/category/{categoryname}")
	public ResponseEntity<Map<String, Object>> viewProductByCategory(@PathVariable("categoryname") String cname) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		try {
			ArrayList<Product> listReturn = proService.viewProductByCategory(cname);
			if (listReturn.size() > 0 && !listReturn.isEmpty()) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listReturn);
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Not Found!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> UpdateProductById(@PathVariable("id") int id,
			@RequestBody Product product) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		System.out.println(product);
		ProductCategory pc = ps.getCategoryById(product.getCategoryid());
		product.setCategoryname(pc.getCategoryname());
		try {
			int result = proService.updateProductDetails(id, product);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product Updated successfully!");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Product not updated!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteProductByID(@PathVariable("id") int id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		try {
			result = proService.deleteProduct(id);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Produt deleted successfully!");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Produt not deleted successfully!");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/generatecode")
	private ResponseEntity<Map<String, Object>> generateProductCode() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		StringBuilder productCode = new StringBuilder();
		productCode.append("PRD");
		do {
			Random random = new Random();
			int x = random.nextInt(99900) + 100;
			productCode.append(x);
		} while (proService.getProductByProductCode(productCode.toString()) != null);
		returnMap.put("productcode", productCode);
		return new ResponseEntity(returnMap, HttpStatus.OK);
	}

	@RequestMapping("/groupcat")
	public ResponseEntity<Map<String, Object>> getGroupCatOfActiveProduct() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		ArrayList<String> listString = new ArrayList<>();
		try {
			ArrayList<Product> listCat = proService.getGroupCategoryOfActiveProduct();
			for (int i = 0; i < listCat.size(); i++) {
				listString.add(listCat.get(i).getCategoryname());
			}
			// System.out.println(listCat);
			if (listString.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listString);
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/applyfilter", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> applyFilters(@RequestBody Map<String, String[]> categoryMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		String[] categories = (String[]) categoryMap.get("categoryname");
		ArrayList<Product> listpro = new ArrayList<>();
		try {
			listpro = proService.ApplyFilterByCategoryName(categories);
			if (listpro.size() > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Details", listpro);
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);
		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/updateqnty/{id}/{qnty}")
	public ResponseEntity<Map<String, Object>> updateInstockQnty(@PathVariable("id") int id,
			@PathVariable("qnty") int qnty) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		boolean flag = false;
		int result = 0;
		System.out.println("product id is "+id+ " \n qnty uis " +qnty);
		try {
			result = proService.updateProductInstockCount(id, qnty);
			if (result > 0) {
				flag = true;
				returnMap.put("Status", flag);
				returnMap.put("Message", "Instock Count Updated Successfully");
			} else {
				returnMap.put("Status", flag);
				returnMap.put("Message", "Instock Count does Not Updated Successfully");
			}
			return new ResponseEntity(returnMap, HttpStatus.OK);

		} catch (Exception e) {
			returnMap.put("Status", flag);
			returnMap.put("Message", "Something Went Wrong!");
			return new ResponseEntity(returnMap, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
