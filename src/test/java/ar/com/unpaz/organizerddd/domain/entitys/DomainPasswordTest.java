package ar.com.unpaz.organizerddd.domain.entitys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainPasswordTest {

	
	private Password passEmpty;
	private Password passMin;
	private Password passMax;


	@Test
	public void ValidacionPasswordCamposVacios() {
		passEmpty=new Password("","fernando","corinaldesi",30038420);
		assertTrue(passEmpty.emptySiteVal());
		passEmpty=new Password("fernando","","corinaldesi",30038420);
		assertTrue(passEmpty.emptyUserVal());
		passEmpty=new Password("fernando","fernando","",30038420);
		assertTrue(passEmpty.emptyPassVal());
	}
	@Test
	public void ValidacionPasswordTamañoMinimo() {
		passMin=new Password("f","fernando","corinaldesi",30038420);
		assertTrue(passMin.MinSiteVal());
		passMin=new Password("fernando","f","corinaldesi",30038420);
		assertTrue(passMin.MinUserVal());
		passMin=new Password("fernando","fernando","c",30038420);
		assertTrue(passMin.MinPassVal());
	}
	@Test
	public void ValidacionPasswordTamañoMaximo() {
		passMax=new Password("ffffffffffffffffffffffffffffffff","fernando","corinaldesi",30038420);
		assertTrue(passMax.MaxSiteVal());
		passMax=new Password("fernando","ffffffffffffffffffffffffffffffff","corinaldesi",30038420);
		assertTrue(passMax.MaxUserVal());
		passMax=new Password("fernando","fernando","ffffffffffffffffffffffffffffffff",30038420);
		assertTrue(passMax.MaxPassVal());
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
