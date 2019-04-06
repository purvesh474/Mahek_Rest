
package Service;

import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import Dao.Customer;
import Service.Interface.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public ArrayList<Customer> checkLogin(Map<String, String> credential) {
		//Map<String, String> returnMap=new Map<String, String>();	
		String username=credential.get("username");
		String password=credential.get("password");
		String usertype=credential.get("usertype");
		ArrayList<Customer> customer=null;
		String sql="select * from tblcustomer where username=? and BINARY password=? and usertype=?";
		
		try {
		customer= (ArrayList<Customer>) jdbcTemplate.query(sql, new Object[] {username,password,usertype},new BeanPropertyRowMapper(Customer.class));
		}catch(Exception e) {
			return null;
		}
		return customer;
	}

	/*@Override
	public ArrayList<Customer> checkAdminLogin(Map<String, String> credential) {
		String username=credential.get("username");
		String password=credential.get("password");
		String usertype=credential.get("usertype");
		ArrayList<Customer> customer=null;
		String sql="select * from tblcustomer where username=? and password=? and usertype=?";
		
		try {
		customer= (ArrayList<Customer>) jdbcTemplate.query(sql, new Object[] {username,password,usertype},new BeanPropertyRowMapper(Customer.class));
		}catch(Exception e) {
			return null;
		}
		return customer;
	}*/

}

