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

import Dao.Order;
import Service.Interface.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Order getOrderById(int id) {
		String sql="select * from tblorder where orderid=?";
		Order order=null;
		try {
		order=(Order) jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper(Order.class));	
		}catch (Exception e) {
			return null;
		}
		return order;
	}

	@Override
	public ArrayList<Order> getAllOrder() {
		String sql="select * from tblorder";
		ArrayList<Order> listorder=(ArrayList<Order>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Order.class));
		return listorder;
	}

	@Override
	public Order getOrderByUserID(int userid) {
		String sql="select * from tblcustomer where userid=?";
		Order order=null;
		try {
			order=(Order) jdbcTemplate.queryForObject(sql, new Object[] {userid},new BeanPropertyRowMapper(Order.class));
			
		}catch (Exception e) {
			return null;
		}
				
		return order;
	}

	@Override
	public int addOrder(Order order) {
		String sql="INSERT INTO tblorder (ordername,userid,qnty,totalprice,orderstatus,agentname,villagecity,taluka,district,pincode,name,emailid,mobile,address,usertype) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, order.getOrdername());
				ps.setInt(2,order.getUserid());
				ps.setInt(3, order.getQnty());
				ps.setString(4, order.getTotalprice());
				ps.setString(5, order.getOrderstatus());
				ps.setString(6, order.getAgentname());
				ps.setString(7, order.getVillagecity());
				ps.setString(8, order.getTaluka());
				ps.setString(9, order.getDistrict());
				ps.setString(10, order.getPincode());
				ps.setString(11, order.getName());
				ps.setString(12, order.getEmailid());
				ps.setString(13, order.getMobile());
				ps.setString(14, order.getAddress());
				ps.setString(15, order.getUsertype());
				
			}
		});
		return result;
	}

}
