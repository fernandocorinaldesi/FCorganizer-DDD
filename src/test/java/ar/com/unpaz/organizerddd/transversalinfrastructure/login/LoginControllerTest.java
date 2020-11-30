package ar.com.unpaz.organizerddd.transversalinfrastructure.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.Component;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.application.dto.Credentials;
import ar.com.unpaz.organizerddd.application.services.AppServicePass;
import ar.com.unpaz.organizerddd.application.services.AppServiceUser;
import ar.com.unpaz.organizerddd.application.services.AppServices;
import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.IRepository;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.InMemoryPasswordRepository;
import ar.com.unpaz.organizerddd.domain.repositorycontracts.InMemoryUserRepository;
import ar.com.unpaz.organizerddd.domain.services.DomainPasswordServices;
import ar.com.unpaz.organizerddd.domain.services.DomainUserService;
import ar.com.unpaz.organizerddd.domain.services.IDomainServices;
import ar.com.unpaz.organizerddd.presentation.controllers.IController;
import ar.com.unpaz.organizerddd.presentation.controllers.Selector;
import ar.com.unpaz.organizerddd.presentation.controllers.SelectorImp;
import ar.com.unpaz.organizerddd.presentation.controllers.ViewAdminController;
import ar.com.unpaz.organizerddd.presentation.controllers.ViewPasswordController;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginView;
import ar.com.unpaz.organizerddd.presentation.loginview.LoginViewOperations;
import ar.com.unpaz.organizerddd.presentation.mainview.AdminView;
import ar.com.unpaz.organizerddd.presentation.mainview.MainView;
import ar.com.unpaz.organizerddd.presentation.mainview.MainViewOperations;
import ar.com.unpaz.organizerddd.presentation.validator.IValidator;
import ar.com.unpaz.organizerddd.presentation.validator.PasswordFrontValidator;
import ar.com.unpaz.organizerddd.presentation.validator.UserFrontValidator;

public class LoginControllerTest {
	private IRepository<Password> passwordrepository;
	private IRepository<User> userrepository;
	private IDomainServices<Password> passdomainservices;
	private IDomainServices<User> userdomainservices;
	private AppServices<Password> appservicepass;
	private AppServices<User> appserviceuser;
	private IValidator<Password> passfrontValidator;
	private IValidator<User> userfrontValidator;
	private MainViewOperations<Password> mainview;
	private MainViewOperations<User> adminview;
	private IController<Password> viewpasscontroller;
	private IController<User> viewadmincontroller;
	private Selector selector;
	private LoginViewOperations loginview;
	private LoginController logincontroller;
	private Credentials credentials;

	@Before
	public void setup() {
		passwordrepository = new InMemoryPasswordRepository();
		userrepository = new InMemoryUserRepository();
		passdomainservices = new DomainPasswordServices();
		userdomainservices = new DomainUserService();
		appservicepass = new AppServicePass(passwordrepository, passdomainservices);
		appserviceuser = new AppServiceUser(userrepository, userdomainservices);
		passfrontValidator = new PasswordFrontValidator();
		userfrontValidator = new UserFrontValidator();
		mainview = new MainView();
		adminview = new AdminView();
		viewpasscontroller = new ViewPasswordController(appservicepass, mainview, passfrontValidator);
		viewadmincontroller = new ViewAdminController(appserviceuser, adminview, userfrontValidator);
		selector = new SelectorImp(viewpasscontroller, viewadmincontroller, appserviceuser, appservicepass);
		loginview = new LoginView();
		logincontroller = new LoginControllerImp(loginview, selector);
	}

	@Test
	public void LoginInconrrectoDeberiaRetornarNull() {
		String user = "error";
		String pass = "error";
		credentials = new Credentials(user, pass);
		assertNull(selector.getUser(credentials));
	}

	@Test
	public void LoginCorrectoDeberiaAbrirModuloAdmin() {
		String user = "admin";
		String pass = "admin";
		logincontroller.checkCredentials(user, pass);
		assertTrue(((Component) adminview).isVisible());
	}
	@Test
	public void LoginInconrrectoNoDeberiaAbrirLaVentanaAdmin() {
		String user = "error";
		String pass = "error";
		credentials = new Credentials(user, pass);
		assertFalse(((Component) adminview).isVisible());
		
	}

	@Test
	public void LoginDeberiaAbrirVentana() {
		logincontroller.startView();
		assertTrue(((Component) loginview).isVisible());
	}
	
	@Test
	public void LoginDeberiaCerrarVentana() {
		logincontroller.closeView();
		assertFalse(((Component) loginview).isVisible());
	}
}
