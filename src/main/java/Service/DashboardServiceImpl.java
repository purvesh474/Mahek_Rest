package Service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import Service.Interface.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int getUserTypeCount(String usertype) {
		String sql="select count(*) from tblcustomer where usertype=?";
		int count=jdbcTemplate.queryForObject(sql, new Object[] {usertype},Integer.class);
		return count;
	}

	

	@Override
	public int getTotalProductCount() {
		String sql="select count(*) from tblproduct";
		int count=jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public int getProductCountByCategoryid(int id) {
		String sql="select  count(*) from tblproduct where categoryid=? ";
		int count=jdbcTemplate.queryForObject(sql, new Object[] {id},Integer.class);
		return count;
	}

}
