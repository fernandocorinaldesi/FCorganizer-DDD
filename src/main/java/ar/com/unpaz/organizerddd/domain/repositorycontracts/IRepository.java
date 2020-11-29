package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.specifications.Specification;


public interface IRepository <E>{
	public List<E> get();
	public void insert(E entity);
	public void delete(E entity);
	public void update(E entity);
	public List<E> query(Specification<E> spec);
}
