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

import Dao.CustomerType;
import Service.Interface.CustomerTypeService;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public CustomerType getCustomerTypeByID(int id) {
		String sql="select * from tblcustomertype where usertypeid=?";
		CustomerType ctype=null;
		
			ctype=(CustomerType) jdbcTemplate.queryForObject(sql,new Object[] {id} ,new BeanPropertyRowMapper(CustomerType.class));
		
		
		return ctype;
	}

	@Override
	public int AddCustomerType(CustomerType cusType) {
		String sql="insert into tblcustomertype (usertype,margin) values(?,?)";
		int result=0;
		
			result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, cusType.getUsertype());
					ps.setString(2, cusType.getMargin());
					
				}
			});
		
		return result;
	}

	@Override
	public CustomerType getCustomerUserTypeByTypeName(String name) {
		String sql="select * from tblcustomertype where usertype=?";
		CustomerType ctype=null;
		
			ctype=(CustomerType) jdbcTemplate.queryForObject(sql,new Object[] {name},new BeanPropertyRowMapper(CustomerType.class));
		
		return ctype;
	}

	@Override
	public int updateCustomerTypeById(int id,CustomerType ctype) {
		String sql="update tblcustomertype set usertype=?,margin=? where usertypeid=? ";
		int result=0;
		
			result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					
					ps.setString(1, ctype.getUsertype());
					ps.setString(2, ctype.getMargin());
					ps.setInt(3, id);
				}
			});
		
		return result;
	}

	@Override
	public int updatemargin(String margin,String name) {
		String sql="update tblcustomertype set margin=? where usertypename=? ";
		int result=0;
		try {
			result=jdbcTemplate.update(sql,new Object[] {margin,name});
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public ArrayList<CustomerType> getAllCType() {
		String sql="select * from tblcustomertype";
		ArrayList<CustomerType> list=(ArrayList<CustomerType>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(CustomerType.class));
		
		return list;
	}

}
