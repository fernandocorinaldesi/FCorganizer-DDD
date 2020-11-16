package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public class SelectorImp implements Selector{
	LoginController loginController;
	IController<Password> mainview;
	IController<User> adminview;
	public SelectorImp(
			IController<Password> mainview,
			IController<User> adminview) {
		   this.mainview=mainview;
		   this.adminview=adminview;
	
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

}
