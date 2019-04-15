package Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import Dao.Customer;
import Service.Interface.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "select * from tblcustomer where userid=?";
		Customer customer = null;

		customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper(Customer.class));

		return customer;

	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		String sql = "select * from tblcustomer";
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = (ArrayList<Customer>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));

		return customers;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		String sql = "select * from tblcustomer where username=?";
		Customer customer = null;
		try {
			customer = (Customer) jdbcTemplate.queryForObject(sql, new Object[] { username },
					new BeanPropertyRowMapper(Customer.class));
		} catch (Exception e) {
			return null;
		}
		return customer;
	}

	@Override
	public int deleteCustomerById(int id) {
		String sql = "delete from tblcustomer where userid=?";
		int result = jdbcTemplate.update(sql, new Object[] { id });
		return result;
	}

	@Override
	public int insertCustomerDetails(Customer cus) {
		int result = 0;
		System.out.println(cus.toString());
		String sql = "INSERT INTO tblcustomer (username, password, firstname, lastname, emailid, mobile, address, usertype, loginatmp, paramstr1, paramstr2,"
				+ " paramstr3, createdate, updatedate, userstatus, agentname, shopname,villagecity,taluka,district,pincode,adharnumber,voterid,pannumber,licenceshop,gstnumber,ownerphoto,shopphoto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
		result = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, cus.getUsername());
				ps.setString(2, cus.getPassword());
				ps.setString(3, cus.getFirstname());
				ps.setString(4, cus.getLastname());
				ps.setString(5, cus.getEmailid());
				ps.setString(6, cus.getMobile());
				ps.setString(7, cus.getAddress());
				ps.setString(8, cus.getUsertype());
				ps.setInt(9, cus.getLoginatmp());
				ps.setString(10, cus.getParamstr1());
				ps.setString(11, cus.getParamstr2());
				ps.setString(12, cus.getParamstr3());
				ps.setTimestamp(13, cus.getCreatedate());
				ps.setTimestamp(14,cus.getUpdatedate());
				ps.setString(15, cus.getUserstatus());
				ps.setString(16, cus.getAgentname());
				ps.setString(17, cus.getShopname());
				ps.setString(18, cus.getVillagecity());
				ps.setString(19, cus.getTaluka());
				ps.setString(20, cus.getDistrict());
				ps.setString(21, cus.getPincode());
				ps.setString(22, cus.getAdharnumber());
				ps.setString(23, cus.getVoterid());
				ps.setString(24, cus.getPannumber());
				ps.setString(25, cus.getLicenceshop());
				ps.setString(26, cus.getGstnumber());
				ps.setString(27, cus.getOwnerphoto());
				ps.setString(28, cus.getShopphoto());
			}
			
		});
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}

	public int UpdateCustomer(int id, Customer cus) {
		String sql = "UPDATE tblcustomer SET firstname=?,lastname=?,emailid=?,mobile=?,address=?,userstatus=?,agentname=?,shopname=?,"
				+ "villagecity=?,taluka=?,district=?,pincode=?,shopphoto=? where userid=?";
		int result = 0;
try {
		result = jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setString(1, cus.getFirstname());
				ps.setString(2, cus.getLastname());
				ps.setString(3, cus.getEmailid());
				ps.setString(4, cus.getMobile());
				ps.setString(5, cus.getAddress());
				ps.setString(6, cus.getUserstatus());
				ps.setString(7, cus.getAgentname());
				ps.setString(8, cus.getShopname());
				ps.setString(9, cus.getVillagecity());
				ps.setString(10, cus.getTaluka());
				ps.setString(11, cus.getDistrict());
				ps.setString(12, cus.getPincode());
				ps.setString(13, cus.getShopphoto());
				ps.setInt(14, id);
			}
		});
}catch (Exception e) {
	System.out.println(e);
}

		return result;
	}

	@Override
	public int changePassword(Map<String, String> map) {
		String sql="update tblcustomer set password=? where userid=? ";
		String cpassword=map.get("password");
		String id=map.get("userid");
		String newPassword=map.get("newpassword");
		int result=0;
		boolean flag=checkPassword(cpassword, Integer.parseInt(id));
		if(flag==true) {
		result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, newPassword);
				ps.setInt(2, Integer.parseInt(id));
			}
		});
		}
		return result;
	}
	
	private boolean checkPassword(String password,int id ) {
		String sql="select * from tblcustomer where BINARY password=? and userid=?";
		try {
		Customer cus=(Customer) jdbcTemplate.queryForObject(sql, new Object[] {password,id},new BeanPropertyRowMapper(Customer.class));
		if(cus!=null) {
			return true;
		}
		}catch (Exception e) {
		return false;
		}
		return false;
	}

}
