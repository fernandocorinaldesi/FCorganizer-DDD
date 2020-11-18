package ar.com.unpaz.organizerddd.application.services;

import java.util.List;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;
import ar.com.unpaz.organizerddd.domain.specifications.ByDniSpecification;
import ar.com.unpaz.organizerddd.domain.specifications.Specification;

public class AppServicePass extends AppServiceImp<Password>{
	   private User user;
		public AppServicePass(IRepository<Password> passwordrepository, 
				             IDomainServices<Password> domainservices) {
			
			super(passwordrepository, 
				  domainservices);
			
			
			// TODO Auto-generated constructor stub
		}
		public void setUser(User user) {
			this.user=user;
		}
		@Override
		public List<Password> getList() {
			// TODO Auto-generated method stub
			Specification<Password>spec=new  ByDniSpecification(this.user.getDni());
			return this.repository.query(spec);
		};

}
