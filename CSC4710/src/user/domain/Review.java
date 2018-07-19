package user.domain;

import java.sql.Date;

public class Review {
	
	private int reportid;
	private String sdate;
	private String comment;
	private String recommendation;
	private int paperid;
	private String email;
	
	public int getReportid(){
		return reportid;
	}
	
	public void setReportid(int reportid){
		this.reportid = reportid;
	}
	
	public String getSdate(){
		return sdate;
	}
	
	public void setSdate(String sdate){
		this.sdate = sdate;
	}
	
	public String getComment(){
		return comment;
	}
	
	public void setComment(String comment){
		this.comment = comment;
	}
	
	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	public int getPaperid() {
		return paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String toString() {
		return "Review [ reportid=" + reportid + ", sdate="
				+ sdate + ", comment=" + comment +", recommendation=" + recommendation +
				", paperid" + paperid + ", email" + email +"]";
	}

	
}
