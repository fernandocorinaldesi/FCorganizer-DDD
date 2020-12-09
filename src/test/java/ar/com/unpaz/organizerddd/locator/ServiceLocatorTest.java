package ar.com.unpaz.organizerddd.locator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.domain.entitys.User;

public class ServiceLocatorTest {
	
	private Iservice service;
	private User user;
	
	
	
	@Before
	public void setup() {
		service=new ServiceLocator();
	}
	
	@Test
	public void deberiaDevolverLaDependenciaAgregada() {
		user= new User("fer","fer","fer","fer","fer");
		service.addDependency(User.class,user);
		assertEquals(user,service.getDependency(User.class));
	}

}
