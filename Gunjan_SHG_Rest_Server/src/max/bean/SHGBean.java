package max.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="mst_shg")
public class SHGBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shg_id")
	int shg_id;
	@Column(name="group_name")
	String gname;
	
	@Column(name="acc_no")
	String an;
	@Column(name="ifsc_no")
	String ifsc;
	@Column(name = "bank_name")
	String bankName;
	@Column(name = "branch_name")
	String branchName;
	@Column(name = "state_code")
	String stCode;
	@Column(name = "district_code")
	String districtCode;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="shg_id")
	List<MemberNBean> mbean;

	

	public int getShg_id() {
		return shg_id;
	}

	public void setShg_id(int shg_id) {
		this.shg_id = shg_id;
	}

	public List<MemberNBean> getMbean() {
		return mbean;
	}

	public void setMbean(List<MemberNBean> mbean) {
		this.mbean = mbean;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
