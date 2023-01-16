package max;

import java.util.List;

public class SHGBean {
	
	int shg_id;
	
	String gname;
	
	
	String an;
	
	String ifsc;
	
	String bankName;
	
	String branchName;
	
	String stCode;
	
	String districtCode;
	
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
