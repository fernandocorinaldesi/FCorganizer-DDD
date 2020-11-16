package ar.com.unpaz.organizerddd.domain.repositorycontracts;

public interface Specification<T> {

  public boolean specified(T entity);

}
