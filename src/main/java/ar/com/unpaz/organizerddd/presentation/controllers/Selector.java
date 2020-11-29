package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.application.dto.Credentials;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.transversalinfrastructure.login.LoginController;

public interface Selector {
	public void sendLogOut(LoginController loginController);
	public void startApp(User usuario);
	public void loadAdminModule();
	public User getUser(Credentials credentials);

}
