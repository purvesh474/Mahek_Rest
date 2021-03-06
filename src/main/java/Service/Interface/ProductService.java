package Service.Interface;

import java.util.ArrayList;

import Dao.Product;

public interface ProductService {

	public int addProductDetails(Product product);

	public int updateProductDetails(int id, Product product);

	public Product getProductByID(int id);

	public ArrayList<Product> getAllProduct();
	public ArrayList<Product> getAllActiveProduct();

	public ArrayList<Product> searchProductByName(String name);

	public int deleteProduct(int id);
	
	public ArrayList<Product> viewProductByCategory(String category);
	
	public Product getProductByProductCode(String productcode);

	public ArrayList<Product> getGroupCategoryOfActiveProduct();
	
	public ArrayList<Product> ApplyFilterByCategoryName(String[] categories);
	
	public int updateProductInstockCount(int productid,int qnty);
}
