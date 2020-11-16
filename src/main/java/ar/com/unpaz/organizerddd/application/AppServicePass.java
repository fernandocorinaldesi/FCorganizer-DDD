package ar.com.unpaz.organizerddd.application;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;

public class AppServicePass extends AppServiceImp<Password>{

	public AppServicePass(IRepository<Password> passwordrepository, 
			             IDomainServices<Password> domainservices) {
		
		super(passwordrepository, 
			  domainservices);
		// TODO Auto-generated constructor stub
	}

}
