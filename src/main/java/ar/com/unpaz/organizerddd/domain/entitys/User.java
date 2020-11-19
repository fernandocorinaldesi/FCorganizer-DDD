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
	public boolean emptyUserVal() {
		// TODO Auto-generated method stub
		return (this.user.isEmpty());
	}
	public boolean MinUserVal() {
		// TODO Auto-generated method stub
		return(this.user.length()<3);
	}
	public boolean MaxUserVal() {
		// TODO Auto-generated method stub
		return(this.user.length()>31);
	}
	public boolean emptyDniVal() {
		// TODO Auto-generated method stub
		return (String.valueOf(this.dni).isEmpty());
	}
	public boolean MinDniVal() {
		// TODO Auto-generated method stub
		return (String.valueOf(this.dni).length()<6);
	}
	public boolean MaxDniVal() {
		// TODO Auto-generated method stub
		return (String.valueOf(this.dni).length()>9);
	}
	public boolean emptyNameVal() {
		// TODO Auto-generated method stub
		return (this.name.isEmpty());
	}
	public boolean MinNameVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()<3);
	}
	public boolean MaxNameVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()>31);
	}
	public boolean emptysecondNameVal() {
		// TODO Auto-generated method stub
		return (this.secondName.isEmpty());
	}
	public boolean MinsecondNameVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()<2);
	}
	public boolean MaxsecondNameVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()>31);
	}
	public boolean emptyPassVal() {
		// TODO Auto-generated method stub
		return (this.pass.isEmpty());
	}
	public boolean MinPassVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()<5);
	}
	public boolean MaxPassVal() {
		// TODO Auto-generated method stub
		return(this.pass.length()>13);
	}
	@Override
	public String toString() {
		return "User [pass=" + pass + ", user=" + user + ", name=" + name + ", secondName=" + secondName + ", dni="
				+ dni + "]";
	}
	

}
