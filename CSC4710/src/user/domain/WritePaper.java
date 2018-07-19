package user.domain;

public class WritePaper {
	
	private int paperid;
	private int ordersignificance;
	private String email;
	
	public int getPaperid(){
		return paperid;
	}
	
	public void setPaperid(int paperid){
		this.paperid = paperid;
	}
	
	public int getOrdersignificance(){
		return ordersignificance;
	}
	
	public void setOrdersignificance(int ordersignificance){
		this.ordersignificance = ordersignificance;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "WritePaper [ paperid=" + paperid + ", ordersignificance="
				+ ordersignificance + ", email=" + email +"]";
	}
}
