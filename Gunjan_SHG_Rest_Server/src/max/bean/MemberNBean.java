package max.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_member")
public class MemberNBean implements Serializable

{
	
	private static final long serialVersionUID = 1L;
	@Column(name = "member_name")
	String mname;
	@Column(name = "member_age")
	String mage;
	@Id
	@Column(name = "member_adhar")
	String madhar;
	
	
	public MemberNBean() {
		// TODO Auto-generated constructor stub
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMage() {
		return mage;
	}
	public void setMage(String mage) {
		this.mage = mage;
	}
	public String getMadhar() {
		return madhar;
	}
	public void setMadhar(String madhar) {
		this.madhar = madhar;
	}
	
	
	
}
