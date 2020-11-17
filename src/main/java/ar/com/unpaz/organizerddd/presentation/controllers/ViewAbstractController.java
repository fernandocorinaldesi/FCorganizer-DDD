package ar.com.unpaz.organizerddd.presentation.controllers;

import java.util.List;

import ar.com.unpaz.organizerddd.application.AppServices;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public abstract class ViewAbstractController<E> implements IController<E>{
	protected AppServices<E> appservice;
	protected MainViewOperations<E> mainview;
	protected IValidator<E> frontValidator;

	public ViewAbstractController(AppServices<E> appservice, MainViewOperations<E> mainview,
		IValidator<E> frontValidator) {
		this.mainview=mainview;
		this.appservice=appservice;
		this.frontValidator=frontValidator;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<E> get() {
		// TODO Auto-generated method stub
		return appservice.getList();
	}

	@Override
	public boolean register(E entity) {
		// TODO Auto-generated method stub
		if (appservice.addEntity(entity))
			updateView();
		return true;

	}

	@Override
	public void delete(int pswId) {
		// TODO Auto-generated method stub
		appservice.delEntity(pswId);

	}

	
	@Override
	public void startView() {
		// TODO Auto-generated method stub
		mainview.setVisible();
	}

	@Override
	public List<String> getErrors() {
		// TODO Auto-generated method stub
		return frontValidator.getErrorMsg();
	}

	@Override
	public boolean validate(E entity) {
		// TODO Auto-generated method stub
		frontValidator.ExecuteValidator(entity);
		return frontValidator.isValid();
	}

	@Override
	public void load() {
		mainview.load();
		// TODO Auto-generated method stub

	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		mainview.update();
	}
	@Override
	public void setLogOut(LoginController loginController) {
		mainview.setLogOut(loginController);
		
	}
	
	public abstract void injectControllerInView();


}