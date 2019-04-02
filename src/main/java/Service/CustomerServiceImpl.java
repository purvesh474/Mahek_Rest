package Service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import Dao.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Customer getCustomerById(int id) {
		String sql="select * from tblcustomer where userid=?";
		/*
		 * SqlParameterSource mapParam=new MapSqlParameterSource("userid",id); Customer
		 * customer= jdbcTemplate.queryForObject(sql, new
		 * SqlParameterSource(),(RowMapper<T>) mapParam);
		 */
		Customer customer = (Customer)jdbcTemplate.queryForObject(
				sql, new Object[] { id }, 
				new BeanPropertyRowMapper(Customer.class));
		if(customer==null) {
			return null;
		}
		
		return customer;
		
		
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		String sql="select * from tblcustomer";
		ArrayList<Customer> customers=new ArrayList<Customer>();
		customers = (ArrayList<Customer>) jdbcTemplate.query(sql,new BeanPropertyRowMapper(Customer.class));
		
		return customers;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		String sql="select * from tblcustomer where username=?";
		Customer customer=null;
		try {
		customer=(Customer)jdbcTemplate.queryForObject(sql, new Object[] {username},new BeanPropertyRowMapper(Customer.class));
		}catch(Exception e) {
			return null;
		}
		return customer;
	}

	@Override
	public int deleteCustomerById(int id) {
		String sql="delete from tblcustomer where userid=?";
		int result=jdbcTemplate.update(sql, new Object[] {id});
		return result;
	}

	@Override
	public int insertCustomerDetails(Customer cus) {
		int result = 0;
		System.out.println(cus.toString());
		String sql="INSERT INTO tblcustomer (username, password, firstname, lastname, emailid, mobile, address, usertype, loginatmp, paramstr1, paramstr2, paramstr3, createdate, updatedate, userstatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] obj=new Object[] {
				
				//cus.getUserid(),
				cus.getUsername(),
				cus.getPassword(),
				cus.getFirstname(),
				cus.getLastname(),
				cus.getEmailid(),
				cus.getMobile(),
				cus.getAddress(),
				cus.getUsertype(),
				cus.getLoginatmp(),
				cus.getParamstr1(),
				cus.getParamstr2(),
				cus.getParamstr3(),
				cus.getCreatedate(),
				cus.getUpdatedate(),
				cus.getUserstatus()
		};
		int[] types = new int[] {
				//Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.TINYINT,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.TIMESTAMP,
				Types.TIMESTAMP,
				Types.VARCHAR
				
		};
		
		try {
		result=jdbcTemplate.update(sql, obj,types);
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	

}
