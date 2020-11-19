package ar.com.unpaz.organizerddd.presentation.controllers;

import java.util.List;

import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.locator.Context;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;
import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public abstract class ViewAbstractController<E> implements IController<E>{
	protected AppServices<E> appservice;
	protected MainViewOperations<E> mainview;
	protected IValidator<E> frontValidator;
	protected int dni;

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
	public void delete(E entity) {
		// TODO Auto-generated method stub
		appservice.delEntity(entity);

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
	public void showWarningInMemMsg() {
		
		mainview.showInMemWarning();
		
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
	@Override
	public void setDefault(int dni) {
		this.dni=dni;
	}
	
	@Override
	public int getDefault() {
		return dni;
	}
	
	public abstract void injectControllerInView();


}
