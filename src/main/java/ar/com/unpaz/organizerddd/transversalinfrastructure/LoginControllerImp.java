package ar.com.unpaz.organizerddd.transversalinfrastructure;

import ar.com.unpaz.organizerddd.presentation.controllers.Selector;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginViewOperations;

public class LoginControllerImp implements LoginController{
    
	LoginViewOperations loginview;
	Selector selector;

	public LoginControllerImp(LoginViewOperations loginview, 
			                  Selector selector) {
		this.loginview=loginview;
		this.selector=selector;
		this.loginview.setController(this);
		this.selector.sendLogOut(this);
	}
	@Override
	public void startView() {
		// TODO Auto-generated method stub
		loginview.startView();
	}
	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		loginview.close();
	}

	@Override
	public void checkCredentials(String user, String pass) {
		// TODO Auto-generated method stub
		if(user.equals("admin") && pass.equals("admin")) {
			selector.loadAdminModule();
        	loginview.close();
		}
		if(user.equals("fer") && pass.equals("admin")) {
			selector.startApp();
        	loginview.close();
		}
	
	}
	

}
