package ar.com.unpaz.organizerddd.presentation.validator;

import java.util.List;

public interface IValidator <E>{
    public void ExecuteValidator(E entity);
    public List<String> getErrorMsg();
    public boolean isValid();
}
