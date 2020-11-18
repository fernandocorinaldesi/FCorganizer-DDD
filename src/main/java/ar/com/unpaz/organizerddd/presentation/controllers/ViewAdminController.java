package ar.com.unpaz.organizerddd.presentation.controllers;

import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;

public class  ViewAdminController extends ViewAbstractController<User>{

	public ViewAdminController(
	AppServices<User>appservice, 
	MainViewOperations<User> mainview,
	IValidator<User> frontValidator) {
		
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
