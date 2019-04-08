package Dao;

import java.sql.Timestamp;

public class Order {

	private int orderid;
	private String ordername;
	private int userid;
	private Timestamp createdate;
	private Timestamp updateddate;
	private int qnty;
	private String totalprice;
	private String orderstatus;
	private String agentname;
	private String villagecity;
	private String taluka;
	private String district;
	private String pincode;
	private String name;
	private String emailid;
	private String mobile;
	private String address;
	private String usertype;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Timestamp updateddate) {
		this.updateddate = updateddate;
	}

	public int getQnty() {
		return qnty;
	}

	public void setQnty(int qnty) {
		this.qnty = qnty;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getAgentname() {
		return agentname;
	}

	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}

	public String getVillagecity() {
		return villagecity;
	}

	public void setVillagecity(String villagecity) {
		this.villagecity = villagecity;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordername=" + ordername + ", userid=" + userid + ", createdate="
				+ createdate + ", updateddate=" + updateddate + ", qnty=" + qnty + ", totalprice=" + totalprice
				+ ", orderstatus=" + orderstatus + ", agentname=" + agentname + ", villagecity=" + villagecity
				+ ", taluka=" + taluka + ", district=" + district + ", pincode=" + pincode + ", name=" + name
				+ ", emailid=" + emailid + ", mobile=" + mobile + ", address=" + address + ", usertype=" + usertype
				+ "]";
	}

}
