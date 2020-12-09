package ar.com.unpaz.organizerddd.application.services;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;
import ar.com.unpaz.organizerddd.domain.specifications.ByDniSpecification;
import ar.com.unpaz.organizerddd.domain.specifications.Specification;
import ar.com.unpaz.organizerddd.transversalinfrastructure.EnviromentVariables;

public class AppServicePass extends AppServiceImp<Password>{

		public AppServicePass(IRepository<Password> passwordrepository, 
				             IDomainServices<Password> domainservices) {
			
			super(passwordrepository, 
				  domainservices);
			
			
			// TODO Auto-generated constructor stub
		}
	
		@Override
		public List<Password> getList() {
			// TODO Auto-generated method stub
			Specification<Password>spec=new  ByDniSpecification(EnviromentVariables.loggedUserDni);
			return this.repository.query(spec);
		};

}
