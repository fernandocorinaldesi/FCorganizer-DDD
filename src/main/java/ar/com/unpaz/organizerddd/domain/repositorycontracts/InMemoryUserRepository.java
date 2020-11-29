package ar.com.unpaz.organizerddd.domain.repositorycontracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class InMemoryUserRepository extends AbstractInMemoryRepository<User>{
	private Map<String,User> userlist;
	
	public InMemoryUserRepository() {
	    userlist = new HashMap<>();
	    
	  }
	@Override
	public List<User> get() {
		// TODO Auto-generated method stub
		 List<User> result = new ArrayList<>();
		    for (String key : userlist.keySet()) {
		      User user = userlist.get(key);
		      int dni=user.getDni();
		      String name = user.getName();
		      String secondName = user.getSecondName();
		      String username = user.getUser();
		      String pass = user.getPass();
		      result.add(new User(dni,name,secondName,username,pass));
		    }
		    return result;
	}

	@Override
	public void insert(User entity) {
		// TODO Auto-generated method stub
		userlist.put(String.valueOf(entity.getDni()),entity);
	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub
		userlist.remove(String.valueOf(entity.getDni()));
	}
	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub
		userlist.put(String.valueOf(entity.getDni()),entity);
	}

}
