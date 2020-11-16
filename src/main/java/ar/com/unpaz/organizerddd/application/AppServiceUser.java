package ar.com.unpaz.organizerddd.application;

import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;

public class AppServiceUser extends AppServiceImp<User>{

	public AppServiceUser(IRepository<User> userrepository, 
			              IDomainServices<User> domainservices) {
		
		super(userrepository, 
			  domainservices);
		// TODO Auto-generated constructor stub
	}

}
