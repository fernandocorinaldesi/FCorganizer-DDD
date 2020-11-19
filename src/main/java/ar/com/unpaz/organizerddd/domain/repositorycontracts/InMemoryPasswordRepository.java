package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.ArrayList;
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
		  List<Password> result = new ArrayList<>();
		    for (String key : passlist.keySet()) {
		      Password pass = passlist.get(key);
		      int id=pass.getPassId();
		      String site = pass.getSite();
		      String user = pass.getUser();
		      String psw = pass.getPass();
		      int dni = pass.getDni();
		      result.add(new Password(id,site,user,psw,dni));
		    }
		    return result;
	}

	@Override
	public void delete(Password psw) {
		// TODO Auto-generated method stub
		 passlist.remove(String.valueOf(psw.getPassId()));
	}

	@Override
	public void insert(Password entity) {
		// TODO Auto-generated method stub
		numberOfInteractions = getNumberOfInteractions() + 1;
		passlist.put(String.valueOf(numberOfInteractions),adapter(entity));
		
	}
	public int getNumberOfInteractions() {
		return numberOfInteractions;
	}
	private Password adapter(Password entity) {
		return new Password(getNumberOfInteractions(),
				            entity.getSite(),
				            entity.getUser(),
				            entity.getPass(),
				            entity.getDni());
	}

}
