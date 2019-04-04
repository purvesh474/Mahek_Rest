package Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import Dao.ProductCategory;
import Service.Interface.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ProductCategory getCategoryById(int id) {
		ProductCategory category=null;
		String sql="select * from tblproductcategory where categoryid=?";
		try {
		category=(ProductCategory) jdbcTemplate.queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper(ProductCategory.class));
		
		}catch(Exception e) {
			return null;
		}
		return category;
	}

	@Override
	public ArrayList<ProductCategory> searchCategoryByName(String category) {
		String sql="select * from tblproductcategory where categoryname like ?";
		ArrayList<ProductCategory> categoryList=null;
		try {
			categoryList=(ArrayList<ProductCategory>) jdbcTemplate.query(sql, new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, "%"+category+"%");
					
				}
			},new BeanPropertyRowMapper(ProductCategory.class));
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
		return categoryList;
	}

	@Override
	public int AddCategory(ProductCategory category) {
		String sql="INSERT INTO tblproductcategory (categoryname,description) VALUES(?,?) ";
		int result=0;
		try {
			//System.out.println(category.toString());
		Object[] obj=new Object[] {
			category.getCategoryname(),
			category.getDescription()
		};
		int[] types=new int[] {
			Types.VARCHAR,
			Types.VARCHAR
		};
		result=jdbcTemplate.update(sql, obj,types);
		}catch(Exception e ) {
			//System.out.println(e);
			return 0;
		}
		
		return result;
	}
	
	public int updateCategory(int id,ProductCategory category) {
		String sql="UPDATE tblproductcategory SET categoryname = ?, description= ? WHERE categoryid=?";
		int result=0;
		try {
			result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, category.getCategoryname());
					ps.setString(2, category.getDescription());
					ps.setInt(3, id);
					
				}
			});
		}catch(Exception e) {
			return 0;
		}
		return result;
		
	}

	@Override
	public ArrayList<ProductCategory> getAllCategory() {
		String sql="select * from tblproductcategory ";
		ArrayList<ProductCategory> listCat=(ArrayList<ProductCategory>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(ProductCategory.class));
		
		return listCat;
	}
	
	public int deleteCategoryById(int id) {
		String sql = "delete from tblproductcategory where categoryid=?";
		int result = jdbcTemplate.update(sql, new Object[] { id });
		return result;
	}

}
