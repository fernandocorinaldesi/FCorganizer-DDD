package ar.com.unpaz.organizerddd.domain.entitys;

public class User extends Entity<User>{
	String pass;
	String user;
	String name;
	String secondName;
	int dni;
	public User(int dni,String name,String secondName,String user,String pass) {
		this.dni=dni;
		this.pass=pass;
		this.user=user;
		this.name=name;
		this.secondName=secondName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	

}
