package user.domain;

public class Author {
	private String email;
	private String firstname;
	private String lastname;
	private String affiliation;
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	
	
	public String getAffiliation(){
		return affiliation;
	}
	
	public void setAffiliation(String affiliation){
		this.affiliation = affiliation;
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
	
	public String toString() {
		return "Author [ email=" + email + ", first name="
				+ firstname + ", last name=" + lastname +", affiliation=" + affiliation +"]";
	}
	
}
