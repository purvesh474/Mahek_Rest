package Dao;

import java.sql.Timestamp;

public class Product {
	
	private int productid;
	private String productname;
	private String productcode;
	private String description;
	private String uom;
	private String imagepath;
	private String productstatus;
	private String price;
	private int productrating;
	private Timestamp createdate;
	private Timestamp updateddate;
	private int categoryid;
	private int instockcount;
	private int totalorderedcount;
	private String retailermarginprice;
	private String customermarginprice;
	private String paramstr1;
	private String paramstr2;
	private String paramstr3;
	private String paramstr4;
	private String paramstr5;
	private String paramstr6;
	private String paramstr7;
	private String paramstr8;
	private String paramstr9;
	private String paramstr10;
	private String categoryname;
	
	
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getProductstatus() {
		return productstatus;
	}
	public void setProductstatus(String productstatus) {
		this.productstatus = productstatus;
	}
	public int getInstockcount() {
		return instockcount;
	}
	public void setInstockcount(int instockcount) {
		this.instockcount = instockcount;
	}
	public int getTotalorderedcount() {
		return totalorderedcount;
	}
	public void setTotalorderedcount(int totalorderedcount) {
		this.totalorderedcount = totalorderedcount;
	}
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
	
	
	public String getRetailermarginprice() {
		return retailermarginprice;
	}
	public void setRetailermarginprice(String retailermarginprice) {
		this.retailermarginprice = retailermarginprice;
	}
	
	public String getCustomermarginprice() {
		return customermarginprice;
	}
	public void setCustomermarginprice(String customermarginprice) {
		this.customermarginprice = customermarginprice;
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
	
	public String getParamstr1() {
		return paramstr1;
	}
	public void setParamstr1(String paramstr1) {
		this.paramstr1 = paramstr1;
	}
	public String getParamstr2() {
		return paramstr2;
	}
	public void setParamstr2(String paramstr2) {
		this.paramstr2 = paramstr2;
	}
	public String getParamstr3() {
		return paramstr3;
	}
	public void setParamstr3(String paramstr3) {
		this.paramstr3 = paramstr3;
	}
	public String getParamstr4() {
		return paramstr4;
	}
	public void setParamstr4(String paramstr4) {
		this.paramstr4 = paramstr4;
	}
	public String getParamstr5() {
		return paramstr5;
	}
	public void setParamstr5(String paramstr5) {
		this.paramstr5 = paramstr5;
	}
	public String getParamstr6() {
		return paramstr6;
	}
	public void setParamstr6(String paramstr6) {
		this.paramstr6 = paramstr6;
	}
	public String getParamstr7() {
		return paramstr7;
	}
	public void setParamstr7(String paramstr7) {
		this.paramstr7 = paramstr7;
	}
	public String getParamstr8() {
		return paramstr8;
	}
	public void setParamstr8(String paramstr8) {
		this.paramstr8 = paramstr8;
	}
	public String getParamstr9() {
		return paramstr9;
	}
	public void setParamstr9(String paramstr9) {
		this.paramstr9 = paramstr9;
	}
	public String getParamstr10() {
		return paramstr10;
	}
	public void setParamstr10(String paramstr10) {
		this.paramstr10 = paramstr10;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productcode=" + productcode
				+ ", description=" + description + ", uom=" + uom + ", imagepath=" + imagepath + ", productstatus="
				+ productstatus + ", price=" + price + ", productrating=" + productrating + ", createdate=" + createdate
				+ ", updateddate=" + updateddate + ", categoryid=" + categoryid + ", instockcount=" + instockcount
				+ ", totalorderedcount=" + totalorderedcount + ", retailermarginprice=" + retailermarginprice
				+ ", customermarginprice=" + customermarginprice + ", paramstr1=" + paramstr1 + ", paramstr2="
				+ paramstr2 + ", paramstr3=" + paramstr3 + ", paramstr4=" + paramstr4 + ", paramstr5=" + paramstr5
				+ ", paramstr6=" + paramstr6 + ", paramstr7=" + paramstr7 + ", paramstr8=" + paramstr8 + ", paramstr9="
				+ paramstr9 + ", paramstr10=" + paramstr10 + "]";
	}
	
	

}
