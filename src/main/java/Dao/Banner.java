package Dao;

import java.sql.Timestamp;

public class Banner {

	private int bannerid;
	private String banner;
	private String bannerstatus;
	private int displayorder;
	private Timestamp createdate;
	private Timestamp updatedate;
	
	
	
	public String getBannerstatus() {
		return bannerstatus;
	}
	public void setBannerstatus(String bannerstatus) {
		this.bannerstatus = bannerstatus;
	}
	public int getBannerid() {
		return bannerid;
	}
	public void setBannerid(int bannerid) {
		this.bannerid = bannerid;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public int getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "Banner [bannerid=" + bannerid + ", banner=" + banner + ", displayorder=" + displayorder
				+ ", createdate=" + createdate + ", updatedate=" + updatedate + "]";
	}
	
	
}
