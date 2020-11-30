package ar.com.unpaz.organizerddd.domain.entitys;

public class User extends Entity<User>{
	private String pass;
	private String user;
	private String name;
	private String secondName;
	private String strdni;
	private int dni;
	
	
	public User(int dni,String name,String secondName,String user,String pass) {
		this.dni=dni;
		this.pass=pass;
		this.user=user;
		this.name=name;
		this.secondName=secondName;
	}
	public User(String strdni,String name,String secondName,String user,String pass) {
		this.strdni=strdni;
		this.pass=pass;
		this.user=user;
		this.name=name;
		this.secondName=secondName;
	}
	public String getStrdni() {
		return strdni;
	}
	public void setStrdni(String strdni) {
		this.strdni = strdni;
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
		return (this.strdni.isEmpty());
	}
	public boolean MinDniVal() {
		// TODO Auto-generated method stub
		return (this.strdni.length()<6);
	}
	public boolean MaxDniVal() {
		// TODO Auto-generated method stub
		return (this.strdni.length()>9);
	}
	public boolean emptyIntDniVal() {
		// TODO Auto-generated method stub
		return String.valueOf(dni).isEmpty();
	}
	public boolean MinIntDniVal() {
		// TODO Auto-generated method stub
		return String.valueOf(dni).length()<8;
		
	}
	public boolean MaxIntDniVal() {
		// TODO Auto-generated method stub
		return String.valueOf(dni).length()>9;
	}
	public boolean emptyNameVal() {
		// TODO Auto-generated method stub
		return (this.name.isEmpty());
	}
	public boolean MinNameVal() {
		// TODO Auto-generated method stub
		return(this.name.length()<3);
	}
	public boolean MaxNameVal() {
		// TODO Auto-generated method stub
		return(this.name.length()>31);
	}
	public boolean emptysecondNameVal() {
		// TODO Auto-generated method stub
		return (this.secondName.isEmpty());
	}
	public boolean MinsecondNameVal() {
		// TODO Auto-generated method stub
		return(this.secondName.length()<2);
	}
	public boolean MaxsecondNameVal() {
		// TODO Auto-generated method stub
		return(this.secondName.length()>31);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((strdni == null) ? 0 : strdni.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dni != other.dni)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (strdni == null) {
			if (other.strdni != null)
				return false;
		} else if (!strdni.equals(other.strdni))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DNI : "+dni+" NOMBRE: "+name+" APELLIDO : "+secondName+" USERNAME : "+user+" PASSWORD : "+pass;
	}
	

}
