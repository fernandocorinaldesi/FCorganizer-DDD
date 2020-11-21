package ar.com.unpaz.organizerddd.presentation.validator;

import java.util.ArrayList;

import ar.com.unpaz.organizerddd.domain.entitys.Password;

public class PasswordFrontValidator extends Validator<Password>{
	
	@Override
	public void executeValidations(Password pass) {
	this.errorsMsg = new ArrayList<String>();
	   userVal(pass);
	   passVal(pass);
	   siteVal(pass);
	}
	
	private void userVal(Password pass) {
		// TODO Auto-generated method stub
		if(pass.emptyUserVal()) {
		this.errorsMsg.add("El campo usuario no puede estar vacio");
		return;
		}
		if(pass.MinUserVal()) {
		this.errorsMsg.add("El minimo de caracteres para el campo usuario es 5");
		return;
		}
		if(pass.MaxUserVal()) {
		this.errorsMsg.add("El maximo de caracteres para el campo usuario es 30");
		}
		
	}
	private void passVal(Password pass) {
		// TODO Auto-generated method stub
		if(pass.emptyPassVal()) {
		this.errorsMsg.add("El campo password no puede estar vacio");
		return;
		}
		if(pass.MinPassVal()) {
		this.errorsMsg.add("El minimo de caracteres para el campo password es 5");
		return;
		}
		if(pass.MaxPassVal()) {
		this.errorsMsg.add("El maximo de caracteres para el campo password es 30");
		}
		
	}

	private void siteVal(Password pass) {
		// TODO Auto-generated method stub
		if(pass.emptySiteVal()) {
		this.errorsMsg.add("El campo site no puede estar vacio");
		return;
		}
		if(pass.MinSiteVal()) {
		this.errorsMsg.add("El minimo de caracteres para el campo site es 5");
		return;
		}
		if(pass.MaxSiteVal()) {
		this.errorsMsg.add("El maximo de caracteres para el campo site es 30");
		}
	}
	

}
