package ar.com.unpaz.organizerddd.presentation.mainview;

import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public interface MainViewOperations<E> {
	public void setVisible();
	public void setController(IController<E> pass);
	public void setLogOut(LoginController login);
	public void load();
	public void update();
	public void showInMemWarning();
}
