package Dao;

import java.sql.Timestamp;

public class Product {
	
	private int productid;
	private String productname;
	private String productcode;
	private String description;
	private String uom;
	private String imagepath;
	private String usertype;
	private String margin;
	private String price;
	private int productrating;
	private Timestamp createdate;
	private Timestamp updateddate;
	private int categoryid;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductcode() {
		return productcode;
	}
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getProductrating() {
		return productrating;
	}
	public void setProductrating(int productrating) {
		this.productrating = productrating;
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
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productcode=" + productcode
				+ ", description=" + description + ", uom=" + uom + ", imagepath=" + imagepath + ", usertype="
				+ usertype + ", margin=" + margin + ", price=" + price + ", productrating=" + productrating
				+ ", createdate=" + createdate + ", updateddate=" + updateddate + ", categoryid=" + categoryid + "]";
	}
	
	

}
