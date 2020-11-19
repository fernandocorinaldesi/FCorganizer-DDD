package ar.com.unpaz.organizerddd.domain.services;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class DomainUserService implements IDomainServices<User>{

	@Override
	public boolean validate(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> filterByUser(List<User> list, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
