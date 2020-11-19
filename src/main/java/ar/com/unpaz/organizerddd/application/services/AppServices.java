package ar.com.unpaz.organizerddd.application.services;

import java.util.List;


public interface AppServices <E>{
	public List<E> getList();
	public boolean addEntity(E entity);
	public void delEntity(E entity);
	public boolean existEntity(List<E> list,E entity);
}
