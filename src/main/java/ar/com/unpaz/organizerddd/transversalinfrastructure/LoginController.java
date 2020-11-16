package ar.com.unpaz.organizerddd.transversalinfrastructure;

public interface LoginController {
	 public void startView();
	 public void closeView();
     public void checkCredentials(String user,String pass);
}
