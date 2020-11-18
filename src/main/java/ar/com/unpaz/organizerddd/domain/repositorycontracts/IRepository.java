package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.specifications.Specification;


public interface IRepository <E>{
	public List<E> get();
	public void insert(E entity);
	public void delete(int id);
	public List<E> query(Specification<E> spec);
}
