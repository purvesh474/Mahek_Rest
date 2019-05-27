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
		String sql="INSERT INTO tblorder (userid,productid,qnty,categoryid,ordernumber,productname,address,totalprice,usertype,mobile,uom,marginedprice,price,categoryname,orderstatus,agentname,villagecity,taluka,district,pincode,name,emailid,agentemail,mrp) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		int result=0;
		try {
			result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, order.getUserid());
				ps.setInt(2, order.getProductid());
				ps.setInt(3, order.getQnty());
				ps.setInt(4, order.getCategoryid());
				ps.setString(5, order.getOrdernumber());
				ps.setString(6, order.getProductname());
				ps.setString(7, order.getAddress());
				ps.setString(8, order.getTotalprice());
				ps.setString(9, order.getUsertype());
				ps.setString(10, order.getMobile());
				ps.setString(11, order.getUom());
				ps.setString(12, order.getMarginedprice());
				ps.setString(13, order.getPrice());
				ps.setString(14, order.getCategoryname());
				ps.setString(15, order.getOrderstatus());
				ps.setString(16, order.getAgentname());
				ps.setString(17, order.getVillagecity());
				ps.setString(18, order.getTaluka());
				ps.setString(19, order.getDistrict());
				ps.setString(20, order.getPincode());
				ps.setString(21, order.getName());
				ps.setString(22, order.getEmailid());
				ps.setString(23, order.getAgentemail());
				ps.setString(24, order.getMrp());
				
			}
		});
		}catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	@Override
	public ArrayList<Order> getAllOrderByOrderNumber(){
		String sql="select * from tblorder group by ordernumber order by createdate desc";
		ArrayList<Order> listOrder=null;
		try {
		
		listOrder=(ArrayList<Order>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Order.class));
		}catch (Exception e) {
			// TODO: handle exception
		}
			return listOrder;
	}

	@Override
	public ArrayList<Order> getOrderBYOrderNO(String ordernumber) {
	String sql="select * from tblorder where ordernumber=?";
	ArrayList<Order> listOrder = null;
	try {
		listOrder=(ArrayList<Order>) jdbcTemplate.query(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, ordernumber);
				
			}
		},new BeanPropertyRowMapper(Order.class));
	}catch (Exception e) {
		System.out.println(e);
	}
	
		return listOrder;
	}

	@Override
	public ArrayList<Order> getOrderByOrdernoAndUserid(int userid) {
		String sql="select * from tblorder where userid=? group by ordernumber order by createdate desc";
		ArrayList<Order> listOrder = null;
		try {
			listOrder=(ArrayList<Order>) jdbcTemplate.query(sql,new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					
					ps.setInt(1, userid);
					
				}
			},new BeanPropertyRowMapper(Order.class));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return listOrder;
	}

}
