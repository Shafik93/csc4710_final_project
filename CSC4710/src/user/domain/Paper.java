package user.domain;

public class Paper {

	private int paperid;
	private String title;
	private String abs;
	private String pdf;
	
	public int getPaperid() {
		return paperid;
	}
	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbs() {
		return abs;
	}
	public void setAbs(String abstract1) {
		abs = abstract1;
	}
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	
	public String toString() {
		return "Paper [ paperid=" + paperid + ", title="
				+ title + ", abstract=" + abs +", pdf=" + pdf +"]";
	}

}
