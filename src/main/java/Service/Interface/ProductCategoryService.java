package Service.Interface;

import java.util.ArrayList;

import Dao.ProductCategory;

public interface ProductCategoryService {
	
	public ProductCategory getCategoryById(int id);
	public ArrayList<ProductCategory> searchCategoryByName(String category);
	public int AddCategory(ProductCategory category);
	public int updateCategory(int id,ProductCategory category);
	public ArrayList<ProductCategory> getAllCategory();
	public int deleteCategoryById(int id);
}
