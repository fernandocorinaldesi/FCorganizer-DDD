package ar.com.unpaz.organizerddd.domain.services;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ar.com.unpaz.organizerddd.domain.entitys.Password;

public class DomainPasswordServicesTest {
	
	private IDomainServices<Password> passdomainservices;
	private Password pass;
	
	@Before
	  public void setup() {
		passdomainservices = new DomainPasswordServices();
		
	}
	@Test
	public void ValidacionPasswordCamposVacios() {
		pass=new Password("","fernando","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","fernando","",30038420);
		assertTrue(passdomainservices.validate(pass));
	}
	@Test
	public void ValidacionPasswordTamañoMinimo() {
		pass=new Password("f","fernando","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","f","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","fernando","c",30038420);
		assertTrue(passdomainservices.validate(pass));
	}
	@Test
	public void ValidacionPasswordTamañoMaximo() {
		pass=new Password("ffffffffffffffffffffffffffffffff","fernando","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","ffffffffffffffffffffffffffffffff","corinaldesi",30038420);
		assertTrue(passdomainservices.validate(pass));
		pass=new Password("fernando","fernando","ffffffffffffffffffffffffffffffff",30038420);
		assertTrue(passdomainservices.validate(pass));
	}

}
