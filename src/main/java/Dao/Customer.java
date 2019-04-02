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
	@NotNull(message="Firstname Can not be Null")
	private String firstname;
	@NotNull(message="LastName Can not be Null")
	private String lastname;
	@NotNull(message="Email ID Can not be null")
	@Email(message="Email id not valid")
	private String emailid;
	@NotNull(message="Mobile number Can not be null")
	private String mobile;
	@NotNull(message="Address Can not be null")
	private String address;
	@NotNull(message="UserType Can not be null")
	private String usertype;
	private Byte loginatmp;
	private String paramstr1;
	private String paramstr2;
	private String paramstr3;
	private Timestamp createdate;
	private Timestamp updatedate;
	private String userstatus;
	private String message;
	
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
	public Byte getLoginatmp() {
		return loginatmp;
	}
	public void setLoginatmp(Byte loginatmp) {
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
	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", emailid=" + emailid + ", mobile=" + mobile + ", address="
				+ address + ", usertype=" + usertype + ", loginatmp=" + loginatmp + ", paramstr1=" + paramstr1
				+ ", paramstr2=" + paramstr2 + ", paramstr3=" + paramstr3 + ", createdate=" + createdate
				+ ", updatedate=" + updatedate + ", userstatus=" + userstatus + "]";
	}
	
}
