package ar.com.unpaz.organizerddd.domain.entitys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainPasswordTest {

	
	private Password pass;



	@Test
	public void ValidacionPasswordCamposVacios() {
		pass=new Password("","fernando","corinaldesi",30038420);
		assertTrue(pass.emptySiteVal());
		pass=new Password("fernando","","corinaldesi",30038420);
		assertTrue(pass.emptyUserVal());
		pass=new Password("fernando","fernando","",30038420);
		assertTrue(pass.emptyPassVal());
	}
	@Test
	public void ValidacionPasswordTamañoMinimo() {
		pass=new Password("f","fernando","corinaldesi",30038420);
		assertTrue(pass.MinSiteVal());
		pass=new Password("fernando","f","corinaldesi",30038420);
		assertTrue(pass.MinUserVal());
		pass=new Password("fernando","fernando","c",30038420);
		assertTrue(pass.MinPassVal());
	}
	@Test
	public void ValidacionPasswordTamañoMaximo() {
		pass=new Password("ffffffffffffffffffffffffffffffff","fernando","corinaldesi",30038420);
		assertTrue(pass.MaxSiteVal());
		pass=new Password("fernando","ffffffffffffffffffffffffffffffff","corinaldesi",30038420);
		assertTrue(pass.MaxUserVal());
		pass=new Password("fernando","fernando","ffffffffffffffffffffffffffffffff",30038420);
		assertTrue(pass.MaxPassVal());
	}
	@Test
	public void PasswordIgualesDeberiaDevolverTrue() {
	 assertEquals(new Password("fernando","fernando","corinaldesi",30038420),new Password("fernando","fernando","corinaldesi",30038420));
	}
	
	@Test
	public void PasswordDistintosDeberiaDevolverFalse() {
	 assertNotEquals(new Password("fernandooooo","fernando","corinaldesi",30038420),new Password("fernando","fernando","corinaldesi",30038420));
	}
	
	@Test
	public void PasswordHashCodeDistintosDeberiaDevolverFalse() {
	 assertNotEquals(new Password("fernandooo","fernando","corinaldesi",30038420).hashCode(),new Password("fernando","fernando","corinaldesi",30038420).hashCode());
	}
	@Test
	public void PasswordHashCodeIgualesDeberiaDevolverTrue() {
	 assertEquals(new Password("fernando","fernando","corinaldesi",30038420).hashCode(),new Password("fernando","fernando","corinaldesi",30038420).hashCode());
	}
	

}
