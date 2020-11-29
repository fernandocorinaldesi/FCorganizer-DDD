package ar.com.unpaz.organizerddd.presentation.loginview;

import ar.com.unpaz.organizerddd.transversalinfrastructure.login.LoginController;

public interface LoginViewOperations {
      public void startView();
      public void close();
      public void showError(String err);
	  public void setController(LoginController controller);
}
