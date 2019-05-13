package Dao;

import java.sql.Timestamp;

public class Order 
{
	private int orderid;
	private int userid;
	private int productid;
	private int qnty;
	private int categoryid;
	private String ordernumber;
	private String productname;
	private String address;
	private Timestamp createdate;
	private Timestamp updateddate;
	private String totalprice;
	private String usertype;
	private String mobile;
	private String uom;
	private String marginedprice;
	private String price;
	private String categoryname;
	private String orderstatus;
	private String agentname;
	private String agentemail;
	private String villagecity;
	private String taluka;
	private String district;
	private String pincode;
	private String name;
	private String emailid;

	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getMarginedprice() {
		return marginedprice;
	}
	public void setMarginedprice(String marginedprice) {
		this.marginedprice = marginedprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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
	public String getAgentemail() {
		return agentemail;
	}
	public void setAgentemail(String agentemail) {
		this.agentemail = agentemail;
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
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", productid=" + productid + ", qnty=" + qnty
				+ ", categoryid=" + categoryid + ", ordernumber=" + ordernumber + ", productname=" + productname
				+ ", address=" + address + ", createdate=" + createdate + ", updateddate=" + updateddate
				+ ", totalprice=" + totalprice + ", usertype=" + usertype + ", mobile=" + mobile + ", uom=" + uom
				+ ", marginedprice=" + marginedprice + ", price=" + price + ", categoryname=" + categoryname
				+ ", orderstatus=" + orderstatus + ", agentname=" + agentname + ", agentemail=" + agentemail
				+ ", villagecity=" + villagecity + ", taluka=" + taluka + ", district=" + district + ", pincode="
				+ pincode + ", name=" + name + ", emailid=" + emailid + "]";
	}
	
	
}
