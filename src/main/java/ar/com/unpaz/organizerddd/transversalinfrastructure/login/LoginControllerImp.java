package ar.com.unpaz.organizerddd.transversalinfrastructure.login;

import ar.com.unpaz.organizerddd.application.dto.Credentials;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.controllers.Selector;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginViewOperations;
import ar.com.unpaz.organizerddd.transversalinfrastructure.EnviromentVariables;

public class LoginControllerImp implements LoginController{
	private LoginViewOperations loginview;
	private Selector selector;
	boolean viewOn;
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
		this.viewOn=true;
	}
	@Override
	public void closeView() {
		// TODO Auto-generated method stub
		loginview.close();
		this.viewOn=false;
		
	}

	@Override
	public void checkCredentials(String user, String pass) {
		// TODO Auto-generated method stub
		User usuario=selector.getUser(new Credentials(user,pass));
		if(user.equals(EnviromentVariables.ADMINUSER) && pass.equals(EnviromentVariables.ADMINPASS)) {
			selector.loadAdminModule();
        	closeView();
		}
		
		else if(usuario!=null) {
			EnviromentVariables.loggedUserDni=usuario.getDni();
			selector.startApp();
        	loginview.close();
		}

		else {
			showError("login incorrecto");
		}
		
	}
	@Override
	public void showError(String str) {
		// TODO Auto-generated method stub
		loginview.showError(str);
	}
}
