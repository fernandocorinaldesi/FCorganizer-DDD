package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractInMemoryRepository <E> implements IRepository<E>{
	  @Override
	  public List<E> query(Specification<E> spec) {
	    List<E> result = new ArrayList<>();
	    for (E e : get()) {
	      if (spec.specified(e)) {
	        result.add(e);
	      }
	    }
	    return result;
	  }

}
