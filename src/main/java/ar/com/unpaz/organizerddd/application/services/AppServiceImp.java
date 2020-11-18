package ar.com.unpaz.organizerddd.application.services;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;
import ar.com.unpaz.organizerddd.locator.Context;


public abstract class AppServiceImp<E> implements AppServices<E>{
	
	private IRepository<E> passwordrepository;
	private IDomainServices<E> domainservices;
	
	public AppServiceImp(IRepository<E> passwordrepository, IDomainServices<E> domainservices){
		this.passwordrepository=passwordrepository;
		this.domainservices=domainservices;
	}

	@Override
	public List<E> getList() {
		// TODO Auto-generated method stub
		return passwordrepository.get();
	}
	
	@Override
	public void delEntity(int pswId) {
		// TODO Auto-generated method stub
		passwordrepository.delete(pswId);
	}

	@Override
	public boolean addEntity(E pass) {
		// TODO Auto-generated method stub
		if(existEntity(getList(),pass)) {
		Context.APPERRORS="el registro ya existe en la base de datos";
		return false;
		}
		else if(domainservices.validate(pass)){
		Context.APPERRORS="campos invalidos";
		return false;
		}
		else
		passwordrepository.insert(pass);
		return true;	

	}

	@Override
	public boolean existEntity(List<E> passlist,E psw) {
		// TODO Auto-generated method stub
		for(E pass : passlist) {
			if(pass.equals(psw))
				return true;
		}
		return false;
	}

}



	


