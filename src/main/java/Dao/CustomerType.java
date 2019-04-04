package Dao;

public class CustomerType {
	
	private int usertypeid;
	private String usertype;
	private String margin;
	public int getUsertypeid() {
		return usertypeid;
	}
	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getMargin() {
		return margin;
	}
	public void setMargin(String margin) {
		this.margin = margin;
	}
	@Override
	public String toString() {
		return "CustomerType [usertypeid=" + usertypeid + ", usertype=" + usertype + ", margin=" + margin + "]";
	}
	

}
