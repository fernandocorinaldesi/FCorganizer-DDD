package ar.com.unpaz.organizerddd.domain.specifications;

public interface Specification<T> {

  public boolean specified(T entity);

}
