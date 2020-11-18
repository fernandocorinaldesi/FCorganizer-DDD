package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;

public class ViewPasswordController extends ViewAbstractController<Password> {

	public ViewPasswordController(
	AppServices<Password> appservice, 
	MainViewOperations<Password> mainview,
	IValidator<Password> frontValidator) {
		
	super(appservice,
		  mainview,
		  frontValidator);
		
		injectControllerInView();
	}

	@Override
	public void injectControllerInView() {
		// TODO Auto-generated method stub
		mainview.setController(this);
	}

	

}
