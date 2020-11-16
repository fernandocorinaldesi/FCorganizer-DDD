package ar.com.unpaz.organizerddd.presentation.validator;

import java.util.List;

public abstract class Validator <E> implements IValidator<E> {

	public List<String> errorsMsg;

	@Override
	public void ExecuteValidator(E entity) {
		executeValidations(entity);
	}
	public abstract void executeValidations(E entity);

	@Override
	public List<String> getErrorMsg() {
		// TODO Auto-generated method stub
		return errorsMsg;
	}

	@Override
	public boolean isValid() {
	 return (errorsMsg.isEmpty());
	}

}
