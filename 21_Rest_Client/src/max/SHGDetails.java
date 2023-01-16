package max;

import java.util.List;

public class SHGDetails {
String gname;
String dob;
String ifsc;
String stateCode;
String districtCode;
List<MemberDetails> memberDetails;
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getDistrictCode() {
	return districtCode;
}
public void setDistrictCode(String districtCode) {
	this.districtCode = districtCode;
}
public List<MemberDetails> getMemberDetails() {
	return memberDetails;
}
public void setMemberDetails(List<MemberDetails> memberDetails) {
	this.memberDetails = memberDetails;
}



}
