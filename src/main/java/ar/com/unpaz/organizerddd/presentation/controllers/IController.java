package ar.com.unpaz.organizerddd.presentation.controllers;

import java.util.List;

import ar.com.unpaz.organizerddd.transversalinfrastructure.LoginController;

public interface IController <E>{
	public List<E> get();
	public boolean register(E entity);
	public boolean update(E entity);
	public boolean validate(E entity);
	public void delete(E entity);
	public void load();
	public void updateView();
	public void startView();
	public List<String> getErrors();
	public void setLogOut(LoginController loginController);
	public void setDefault(int dni);
	public int getDefault();
	public void showWarningInMemMsg();
	
}
