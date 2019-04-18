package Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import Dao.Product;
import Dao.ProductCategory;
import Service.Interface.ProductCategoryService;
import Service.Interface.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addProductDetails(Product product) {
		String sql = "INSERT INTO tblproduct (productname,productcode,description,uom,imagepath,productstatus,price,retailermarginprice,customermarginprice,productrating,createdate,updateddate,categoryid,instockcount,totalorderedcount,categoryname) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		//ProductCategory pc=ps.getCategoryById(product.getCategoryid());
		int result=0;
		try {
		result = jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getProductname());
				ps.setString(2, product.getProductcode());
				ps.setString(3, product.getDescription());
				ps.setString(4, product.getUom());
				ps.setString(5, product.getImagepath());
				ps.setString(6, product.getProductstatus());
				ps.setString(7, product.getPrice());
				ps.setString(8, product.getRetailermarginprice());
				ps.setString(9, product.getCustomermarginprice());
				//ps.setString(9, product.getMarginprice());
				
				ps.setInt(10, product.getProductrating());
				ps.setTimestamp(11, product.getCreatedate());
				ps.setTimestamp(12, product.getUpdateddate());
				ps.setInt(13, product.getCategoryid());
				ps.setInt(14, product.getInstockcount());
				ps.setInt(15, product.getTotalorderedcount());
				ps.setString(16, product.getCategoryname());
			}
		});
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}

	@Override
	public int updateProductDetails(int id, Product product) {
		String sql="UPDATE tblproduct SET productname=?,description=?,uom=?,productstatus=?,price=?,retailermarginprice=?,customermarginprice=?,instockcount=?,totalorderedcount=?,imagepath=?,categoryid=? , categoryname=? where productid=?";
		//ProductCategory pc=ps.getCategoryById(product.getCategoryid());
		int result=0;
		try {
		 result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, product.getProductname());
				ps.setString(2, product.getDescription());
				ps.setString(3, product.getUom());
				ps.setString(4, product.getProductstatus());
				ps.setString(5, product.getPrice());
				ps.setString(6, product.getRetailermarginprice());
				ps.setString(7, product.getCustomermarginprice());
				ps.setInt(8, product.getInstockcount());
				ps.setInt(9, product.getTotalorderedcount());
				ps.setString(10, product.getImagepath());
				ps.setInt(11, product.getCategoryid());
				ps.setString(12, product.getCategoryname());
				ps.setInt(13, id);
			}
		});
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}

	@Override
	public Product getProductByID(int id) {
		String sql="select * from tblproduct where productid=?";
		Product prd=null;
		try {
	 prd=(Product) jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper(Product.class));	
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return prd;
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		String sql="select * from tblproduct  ORDER BY  categoryname,createdate";
		ArrayList<Product> listReturn=(ArrayList<Product>) jdbcTemplate.query(sql,new BeanPropertyRowMapper(Product.class));
		return listReturn;
	}

	@Override
	public ArrayList<Product> searchProductByName(String name) {
		String sql="select * from tblproduct where productname like ? order by categoryname";
		ArrayList<Product> list=(ArrayList<Product>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, "%"+name+"%");
				
			}
		},new BeanPropertyRowMapper(Product.class));
		return list;
	}

	@Override
	public int deleteProduct(int id) {
		String sql="delete from tblproduct where productid=?";
		int result=jdbcTemplate.update(sql,new Object[] {id});
				
		return result;
	}

	@Override
	public ArrayList<Product> viewProductByCategory(String category) {
		String sql="select * from tblproduct where categoryid=(select categoryid from tblproductcategory where categoryname=?) and productstatus='Enable'";
		ArrayList<Product> listProduct=null;
		try {
			listProduct=(ArrayList<Product>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, category);
				
			}
		},new BeanPropertyRowMapper(Product.class));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listProduct;
	}

	@Override
	public Product getProductByProductCode(String productcode) {
		String sql="select * from tblproduct where productcode=?";
		Product prd=null;
		try {
			prd=(Product) jdbcTemplate.queryForObject(sql, new Object[] {productcode},new BeanPropertyRowMapper(Product.class));
		}catch (Exception e) {
			return null;
		}
		
		return prd;
	}

	@Override
	public ArrayList<Product> getGroupCategoryOfActiveProduct() {
		String sql="select * from tblproduct where productstatus='Enable' group by categoryname order by categoryname";
		
		ArrayList<Product> listCat=(ArrayList<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Product.class));
		
		return listCat;
	}

	@Override
	public ArrayList<Product> getAllActiveProduct() {
		String sql="select * from tblproduct where productstatus='Enable' order by categoryname";
		
		ArrayList<Product> listpro=(ArrayList<Product>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Product.class));
		return listpro;
	}

	@Override
	public ArrayList<Product> ApplyFilterByCategoryName(String[] categories) {
		System.out.println(categories.toString());
		String sql="select * from tblproduct where categoryname in (";
		ArrayList<Product> listPro = null;
		String temp = "";

		for(int i = 0; i < categories.length; i++) {
		  temp += ",?";
		}
		temp = temp.replaceFirst(",", "");
		temp += ")";
		sql=sql+temp+"order by categoryname";
		System.out.println("Query is "+sql);
		try {
		 listPro= (ArrayList<Product>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				for(int i=0;i<categories.length;i++) {
					ps.setString(i+1, categories[i]);
				}
				
			}
		},new BeanPropertyRowMapper(Product.class));
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listPro;
	}

	@Override
	public int updateProductInstockCount(int productid, int qnty) {
		String sql="update tblproduct set instockcount=instockcount-? where productid=?";
		int result=0;
		try {
			result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, qnty);
					ps.setInt(2, productid);
					
				}
			});
		}catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	
}
