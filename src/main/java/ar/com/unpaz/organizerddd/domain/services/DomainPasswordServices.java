package ar.com.unpaz.organizerddd.domain.services;

import ar.com.unpaz.organizerddd.domain.entitys.Password;

public class DomainPasswordServices implements IDomainServices<Password>{
	
	@Override
	public boolean validate(Password psw) {
		// TODO Auto-generated method stub
		return psw.emptyPassVal() ||
			   psw.emptySiteVal() ||
			   psw.emptyUserVal() ||
			   psw.MinPassVal() ||
			   psw.MinSiteVal() ||
			   psw.MinUserVal() ||
			   psw.MaxPassVal() ||
			   psw.MaxSiteVal() ||
			   psw.MaxUserVal();
	}
	
}
