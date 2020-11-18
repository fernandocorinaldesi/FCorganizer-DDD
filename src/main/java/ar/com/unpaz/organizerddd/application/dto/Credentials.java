package ar.com.unpaz.organizerddd.application.dto;

public class Credentials {
	private String userName;
	private String pass;
	public Credentials(String userName,String pass) {
		this.pass=pass;
		this.userName=userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	

}
