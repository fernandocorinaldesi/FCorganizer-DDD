package ar.com.unpaz.organizerddd.presentation.validator;

import java.util.ArrayList;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class UserFrontValidator extends Validator<User> {

	@Override
	public void executeValidations(User user) {
		// TODO Auto-generated method stub
		this.errorsMsg = new ArrayList<String>();
		userVal(user);
		passVal(user);
		dniVal(user);
		nameVal(user);
		secondNameVal(user);
	}

	private void userVal(User user) {
		// TODO Auto-generated method stub
		if (user.emptyUserVal()) {
			this.errorsMsg.add("El campo usuario no puede estar vacio");
		}
		if (user.MinUserVal()) {
			this.errorsMsg.add("El minimo de caracteres para el campo usuario es 4");
		}
		if (user.MaxUserVal()) {
			this.errorsMsg.add("El maximo de caracteres para el campo usuario es 30");
		}

	}

	private void nameVal(User user) {
		// TODO Auto-generated method stub
		if (user.emptyNameVal()) {
			this.errorsMsg.add("El campo nombre no puede estar vacio");
		}
		if (user.MinNameVal()) {
			this.errorsMsg.add("El minimo de caracteres para el campo nombre es 4");
		}
		if (user.MaxNameVal()) {
			this.errorsMsg.add("El maximo de caracteres para el campo nombre es 30");
		}

	}

	private void dniVal(User user) {
		// TODO Auto-generated method stub
		if (user.emptyDniVal()) {
			this.errorsMsg.add("El campo dni no puede estar vacio");
		}
		if (user.MinDniVal()) {
			this.errorsMsg.add("El minimo de caracteres para el campo dni es 7");
		}
		if (user.MaxDniVal()) {
			this.errorsMsg.add("El maximo de caracteres para el campo dni es 8");
		}
	}

	private void passVal(User user) {
		// TODO Auto-generated method stub
		if (user.emptyPassVal()) {
			this.errorsMsg.add("El campo password no puede estar vacio");
		}
		if (user.MinPassVal()) {
			this.errorsMsg.add("El minimo de caracteres para el campo password es 6");
		}
		if (user.MaxPassVal()) {
			this.errorsMsg.add("El maximo de caracteres para el campo password es 12");
		}

	}

	private void secondNameVal(User user) {
		// TODO Auto-generated method stub
		if (user.emptysecondNameVal()) {
			this.errorsMsg.add("El campo apellido no puede estar vacio");
		}
		if (user.MinsecondNameVal()) {
			this.errorsMsg.add("El minimo de caracteres para el campo apellido es 3");
		}
		if (user.MaxsecondNameVal()) {
			this.errorsMsg.add("El maximo de caracteres para el campo apellido es 30");
		}

	}

}
