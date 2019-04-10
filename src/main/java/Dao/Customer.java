package Dao;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.cglib.core.TinyBitSet;

public class Customer {
	
	
	private int userid;
	private String username;
	private String password;

	private String firstname;
	private String lastname;
	private String emailid;
	private String mobile;
	private String address;
	private String usertype;
	private int loginatmp;
	private String paramstr1;
	private String paramstr2;
	private String paramstr3;
	private Timestamp createdate;
	private Timestamp updatedate;
	private String userstatus;
	private String message;
	
	private String agentname;
	private String shopname;
	private String villagecity;
	private String taluka;
	private String district;
	private String pincode;
	private String adharnumber;
	private String voterid;
	private String pannumber;
	private String licenceshop;
	private String gstnumber;
	private String ownerphoto;
	private String shopphoto;
	
	
	
	public String getLicenceshop() {
		return licenceshop;
	}
	public void setLicenceshop(String licenceshop) {
		this.licenceshop = licenceshop;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public int getLoginatmp() {
		return loginatmp;
	}
	public void setLoginatmp(int loginatmp) {
		this.loginatmp = loginatmp;
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
	public String getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}
	
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
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
	public String getAdharnumber() {
		return adharnumber;
	}
	public void setAdharnumber(String adharnumber) {
		this.adharnumber = adharnumber;
	}
	public String getVoterid() {
		return voterid;
	}
	public void setVoterid(String voterid) {
		this.voterid = voterid;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	
	public String getGstnumber() {
		return gstnumber;
	}
	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	}
	public String getOwnerphoto() {
		return ownerphoto;
	}
	public void setOwnerphoto(String ownerphoto) {
		this.ownerphoto = ownerphoto;
	}
	public String getShopphoto() {
		return shopphoto;
	}
	public void setShopphoto(String shopphoto) {
		this.shopphoto = shopphoto;
	}
	
	
	/*public String toString() {
		return "Customer [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", emailid=" + emailid + ", mobile=" + mobile + ", address="
				+ address + ", usertype=" + usertype + ", loginatmp=" + loginatmp + ", paramstr1=" + paramstr1
				+ ", paramstr2=" + paramstr2 + ", paramstr3=" + paramstr3 + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + ", userstatus=" + userstatus + ", message=" + message + ", agentname="
				+ agentname + ", shopname=" + shopname + ", villagecity=" + villagecity + ", taluka=" + taluka
				+ ", district=" + district + ", pincode=" + pincode + ", adharnumber=" + adharnumber + ", voterid="
				+ voterid + ", pannumber=" + pannumber + ", licenceshop=" + licenceshop + ", gstnumber=" + gstnumber
				+ ", ownerphoto=" + ownerphoto + ", shopphoto=" + shopphoto + "]";
	}*/
	
	
}
