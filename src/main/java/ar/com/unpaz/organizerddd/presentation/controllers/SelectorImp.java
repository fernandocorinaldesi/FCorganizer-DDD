package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.application.dto.Credentials;
import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.transversalinfrastructure.login.LoginController;

public class SelectorImp implements Selector{
	LoginController loginController;
	IController<Password> mainview;
	IController<User> adminview;
	AppServices<User> appserviceuser;
	AppServices<Password> appservicepass;
	public SelectorImp(
			IController<Password> mainview,
			IController<User> adminview, 
			AppServices<User> appserviceuser,
			AppServices<Password> appservicepass) {
		   this.mainview=mainview;
		   this.adminview=adminview;
		   this.appserviceuser=appserviceuser;
		   this.appservicepass=appservicepass;
	
	}

	@Override
	public void sendLogOut(LoginController loginController) {
		// TODO Auto-generated method stub
		this.loginController=loginController;
	}

	@Override
	public void startApp() {
		// TODO Auto-generated method stub
	    mainview.load();
		mainview.startView();
		mainview.setLogOut(loginController);
		
		
	}

	@Override
	public void loadAdminModule() {
		// TODO Auto-generated method stub
		adminview.load();
		adminview.startView();
		adminview.setLogOut(loginController);
	}

	@Override
	public User getUser(Credentials credentials) {
		// TODO Auto-generated method stub
		for(User e :appserviceuser.getList()) {
			if(credentials.getUserName().equals(e.getUser())
				&& credentials.getPass().equals(e.getPass())){
				return e;
			}
		}
	  return null;
	}


}
