package ar.com.unpaz.organizerddd.application;

import java.util.List;


public interface AppServices <E>{
	public List<E> getList();
	public boolean addEntity(E entity);
	public void delEntity(int pswId);
	public boolean existEntity(List<E> list,E entity);
}
