package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ar.com.unpaz.organizerddd.domain.entitys.Password;

public class InMemoryPasswordRepository extends AbstractInMemoryRepository<Password>{

	private Map<String,Password> passlist;
	private int numberOfInteractions;
	
	
	public InMemoryPasswordRepository() {
	    passlist = new HashMap<>();
	    numberOfInteractions = 0;
	  }
	@Override
	public List<Password> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Password entity) {
		// TODO Auto-generated method stub
		numberOfInteractions = getNumberOfInteractions() + 1;
	    passlist.put(entity.getSite(),entity);
		
	}
	public int getNumberOfInteractions() {
		return numberOfInteractions;
	}

}
