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

import Dao.Banner;
import Service.Interface.BannerService;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Bean
	public void jdbcTemplate(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insert(Banner banner) {
		String sql="INSERT INTO tblbanner (banner,bannerstatus,displayorder) VALUES(?,?,?)";
		int result=0;
		try {
		result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, banner.getBanner());
				ps.setString(2, banner.getBannerstatus());
				ps.setInt(3, banner.getDisplayorder());
				
			}
		});
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return result;
	}

	@Override
	public Banner getBannerById(int id) {
		String sql="select * from tblbanner where bannerid =?";
		Banner banner=null;
		try {
			banner=(Banner) jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper(Banner.class));
		}catch (Exception e) {
			return null;
		}
		return banner;
	}

	@Override
	public ArrayList<Banner> getAllBanner() {
		String sql="select * from tblbanner ORDER BY createdate DESC";
		ArrayList<Banner> listBanner=(ArrayList<Banner>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Banner.class));
		return listBanner;
	}

	@Override
	public int updateBannerById(int id,Banner banner) {
		String sql="Update tblbanner set banner=?,bannerstatus=?,displayorder=? where bannerid=?";
		int result=jdbcTemplate.update(sql,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, banner.getBanner());
				ps.setString(2, banner.getBannerstatus());
				ps.setInt(3, banner.getDisplayorder());
				ps.setInt(4, id);
				
			}
		});
		return result;
	}

	@Override
	public int deleteBannerbyId(int id) {
		String sql="delete from tblbanner where bannerid=?";

		int result=jdbcTemplate.update(sql,new Object[] {id});
			
		return result;
	}

	
}
