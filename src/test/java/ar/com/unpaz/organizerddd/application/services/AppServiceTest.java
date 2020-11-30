package ar.com.unpaz.organizerddd.application.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.InMemoryPasswordRepository;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.InMemoryUserRepository;
import ar.com.unpaz.organizerddd.domain.services.DomainPasswordServices;
import ar.com.unpaz.organizerddd.domain.services.DomainUserService;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;

public class AppServiceTest {
	private IRepository<Password> passwordrepository;
	private IRepository<User> userrepository;
	private IDomainServices<Password> passdomainservices;
	private IDomainServices<User> userdomainservices;
	private AppServices<Password> appservicepass;
	private AppServices<User> appserviceuser ;
	private User user;
	private Password pass;
	
	
	@Before
	  public void setup() {
		passwordrepository=new InMemoryPasswordRepository();
		userrepository=new InMemoryUserRepository();
		passdomainservices = new DomainPasswordServices();
		userdomainservices = new DomainUserService();
		appservicepass = new AppServicePass(passwordrepository, passdomainservices);
		appserviceuser = new AppServiceUser(userrepository, userdomainservices);
		
  	}
	
	@Test
	public void insertarUsuarioDeberiaFallar() {
		user=new User(0,"","","","");
		assertFalse(appserviceuser.addEntity(user));
	}
	
	@Test
	public void insertarUsuarioDeberiaSerExitoso() {
		user=new User(30038420,"fernando","corinaldesi","fernando","fernando");
		assertTrue(appserviceuser.addEntity(user));
	}
	
	@Test
	public void actualizarUsuarioDeberiaSerExitoso() {
		user=new User(30038420,"fernando","corinaldesi","fernando","fernando");
		appserviceuser.addEntity(user);
		User userupdate=new User(30038420,"juan","corinaldesi","fernando","cambiado");
		appserviceuser.updateEntity(userupdate);
		assertEquals(userupdate,appserviceuser.getList().get(0));
		
	}
	
	@Test
	public void actualizarUsuarioDeberiaFallar() {
		user=new User(30038420,"j","co","","ddddddddddddddddddddddddddddddddddddddando");
		assertFalse(appserviceuser.updateEntity(user));
	}
	
	@Test
	public void GetUsuarioDeberiaDevolverVacio() {
	 assertTrue(appserviceuser.getList().isEmpty());
	}
	
	@Test
	public void insertarPasswordDeberiaSerExitoso() {
		user=new User(30038420,"fernando","corinaldesi","fernando","fernando");
		appserviceuser.addEntity(user);
		((AppServicePass)appservicepass).setUser(user);
		pass=new Password("www.google.com","fernando","fernando",30038420);
		assertTrue(appservicepass.addEntity(pass));
	}
	@Test
	public void insertarPasswordDeberiaFallar() {
		user=new User(30038420,"fernando","corinaldesi","fernando","fernando");
		appserviceuser.addEntity(user);
		((AppServicePass)appservicepass).setUser(user);
		pass=new Password("ww","fo","fernando",30038420);
		assertFalse(appservicepass.addEntity(pass));
	}
	@Test
	public void insertarPasswordDeberiaFallarYaExiste() {
		user=new User(30038420,"fernando","corinaldesi","fernando","fernando");
		appserviceuser.addEntity(user);
		((AppServicePass)appservicepass).setUser(user);
		pass=new Password("www.google.com","fernando","fernando",30038420);
		appservicepass.addEntity(pass);
		assertFalse(appservicepass.addEntity(pass));
	}

}
