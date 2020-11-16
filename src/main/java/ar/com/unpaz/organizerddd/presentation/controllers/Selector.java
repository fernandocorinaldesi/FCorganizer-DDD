package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public interface Selector {
	public void sendLogOut(LoginController loginController);
	public void startApp();
	public void loadAdminModule();

}
