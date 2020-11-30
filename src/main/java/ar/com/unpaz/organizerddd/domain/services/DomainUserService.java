package ar.com.unpaz.organizerddd.domain.services;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class DomainUserService implements IDomainServices<User>{

	@Override
	public boolean validate(User user) {
		// TODO Auto-generated method stub
		return user.emptyPassVal() ||
				   user.emptyUserVal() ||
				   user.emptyNameVal() ||
				   user.emptyIntDniVal() ||
				   user.emptysecondNameVal() ||
				   user.MinIntDniVal() ||
				   user.MinPassVal() ||
				   user.MinNameVal() ||
				   user.MinUserVal() ||
				   user.MinsecondNameVal() ||
				   user.MaxIntDniVal() ||
				   user.MaxsecondNameVal()||
				   user.MaxPassVal() ||
				   user.MaxNameVal() ||
				   user.MaxUserVal()
				   ;
	}

}
