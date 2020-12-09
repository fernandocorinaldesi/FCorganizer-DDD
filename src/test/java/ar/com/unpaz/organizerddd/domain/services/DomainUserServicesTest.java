package ar.com.unpaz.organizerddd.domain.services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class DomainUserServicesTest {
	private IDomainServices<User> userdomainservices;
	private User user;
	
	@Before
	  public void setup() {
		userdomainservices = new DomainUserService();
		
	}
	
	@Test
	public void ValidacionUserCamposVacios() {
		user=new User("","fernando","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","fernando","");
		assertTrue(userdomainservices.validate(user));
	}
	@Test
	public void ValidacionUserTamañoMinimo() {
		user=new User("3","fernando","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","f","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","c","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","f","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","fernando","f");
		assertTrue(userdomainservices.validate(user));
		
	}
	@Test
	public void ValidacionUserTamañoMaximo() {
		user=new User("30000000000","fernando","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","ffffffffffffffffffffffffffffffffff","corinaldesi","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","cccccccccccccccccccccccccccccccccccccc","fernando","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","ffffffffffffffffffffffffffffffff","fernando");
		assertTrue(userdomainservices.validate(user));
		user=new User("30038420","fernando","corinaldesi","fernando","fffffffffffffffffffffffffffffff");
		assertTrue(userdomainservices.validate(user));
		
	}

}
