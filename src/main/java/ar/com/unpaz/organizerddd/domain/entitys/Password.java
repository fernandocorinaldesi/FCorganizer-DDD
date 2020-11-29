package ar.com.unpaz.organizerddd.domain.entitys;

public class Password extends Entity<Password> {
	
	String pass;
	String user;
	String site;
	int passId;
	int dni;
	
	public Password(int passId,String site,String user,String pass,int dni) {
		this.passId=passId;
		this.pass=pass;
		this.user=user;
		this.site=site;
		this.dni=dni;
	}
	public Password(String site,String user,String pass,int dni) {
		this.pass=pass;
		this.user=user;
		this.site=site;
		this.dni=dni;
	}
	
	public int getPassId() {
		return passId;
	}
	public void setPassId(int userId) {
		passId = userId;
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public boolean emptyPassVal() {
		return (this.pass.isEmpty());
	}
	public boolean emptySiteVal() {
		return (this.site.isEmpty());
	}
	public boolean emptyUserVal() {
		return (this.user.isEmpty());
	}
	public boolean MinPassVal() {
		return(this.pass.length()<5);
	}
	public boolean MinUserVal() {
		return(this.user.length()<5);
	}
	public boolean MinSiteVal() {
		return(this.site.length()<5);
	}
	public boolean MaxPassVal() {
		return(this.pass.length()>30);
	}
	public boolean MaxUserVal() {
		return(this.user.length()>30);
	}
	public boolean MaxSiteVal() {
		return(this.site.length()>30);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
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
		Password other = (Password) obj;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return  "ID: "+passId+" SITIO: "+site+" USUARIO: "+user+" CONTRASEÑA: "+pass;
	}
	

}
