package user.domain;

public class PcMember {
	
	private int memberid;
	private String email;
	private String name;
	
	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String toString() {
		return "PcMember [memberId= " + memberid + ", email=" + email + ", name="
				+ name +"]";
	}

	
}