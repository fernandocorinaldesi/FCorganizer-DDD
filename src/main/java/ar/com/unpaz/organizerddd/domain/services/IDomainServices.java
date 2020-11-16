package ar.com.unpaz.organizerddd.domain.services;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public interface IDomainServices <E>{
	
	public boolean validate(E entity);   
	public List<E> filterByUser(List<E> list,User user);
	//List<Password> filterByUser(List<Password> list,LoginUser entity);
}
