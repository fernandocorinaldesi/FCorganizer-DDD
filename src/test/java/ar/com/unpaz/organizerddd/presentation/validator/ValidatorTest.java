package ar.com.unpaz.organizerddd.presentation.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.domain.entitys.Password;
import ar.com.unpaz.organizerddd.domain.entitys.User;

public class ValidatorTest {
	
	private IValidator<Password> passfrontValidator;
	private IValidator<User> userfrontValidator;
	private User user;
	private Password pass;


	@Before
	public void setup() {
	
		passfrontValidator = new PasswordFrontValidator();
		userfrontValidator = new UserFrontValidator();
		
	}
	@Test
	public void LaValidacionUserDeberiaSerExitosa() {
		user=new User("30038420","fernando","corinaldesi","fernando","fernando");
		userfrontValidator.ExecuteValidator(user);
		assertTrue(userfrontValidator.getErrorMsg().isEmpty());
	}
	@Test
	public void LaValidacionUserDebeFallar() {
		user=new User("","fernando","corinaldesi","fernando","fernando");
		userfrontValidator.ExecuteValidator(user);
		assertFalse((userfrontValidator.getErrorMsg().isEmpty()));
	}
	
	@Test
	public void LaValidacionPasswordDeberiaSerExitosa() {
		pass=new Password("www.fer.com","fernando","corinaldesi",30038420);
		passfrontValidator.ExecuteValidator(pass);
		assertTrue(passfrontValidator.getErrorMsg().isEmpty());
	}
	@Test
	public void LaValidacionPasswordDebeFallar() {
		pass=new Password("www.fer.com","fernando","cori",0);
		passfrontValidator.ExecuteValidator(pass);
		assertFalse(passfrontValidator.getErrorMsg().isEmpty());
	}

}
