package ar.com.unpaz.organizerddd.domain.entitys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DomainUserTest {
	
	private User user;
	
	@Test
	public void ValidacionUserCamposVacios() {
		user=new User("","fernando","corinaldesi","fernando","fernando");
		assertTrue(user.emptyDniVal());
		user=new User("30038420","","corinaldesi","fernando","fernando");
		assertTrue(user.emptyNameVal());
		user=new User("30038420","fernando","","fernando","fernando");
		assertTrue(user.emptysecondNameVal());
		user=new User("30038420","fernando","corinaldesi","","fernando");
		assertTrue(user.emptyUserVal());
		user=new User("30038420","fernando","corinaldesi","fernando","");
		assertTrue(user.emptyPassVal());
	}
	@Test
	public void ValidacionUserTamañoMinimo() {
		user=new User("3","fernando","corinaldesi","fernando","fernando");
		assertTrue(user.MinDniVal());
		user=new User("30038420","f","corinaldesi","fernando","fernando");
		assertTrue(user.MinNameVal());
		user=new User("30038420","fernando","c","fernando","fernando");
		assertTrue(user.MinsecondNameVal());
		user=new User("30038420","fernando","corinaldesi","f","fernando");
		assertTrue(user.MinUserVal());
		user=new User("30038420","fernando","corinaldesi","fernando","f");
		assertTrue(user.MinPassVal());
		
	}
	@Test
	public void ValidacionUserTamañoMaximo() {
		user=new User("30000000000","fernando","corinaldesi","fernando","fernando");
		assertTrue(user.MaxDniVal());
		user=new User("30038420","ffffffffffffffffffffffffffffffffff","corinaldesi","fernando","fernando");
		assertTrue(user.MaxNameVal());
		user=new User("30038420","fernando","cccccccccccccccccccccccccccccccccccccc","fernando","fernando");
		assertTrue(user.MaxsecondNameVal());
		user=new User("30038420","fernando","corinaldesi","ffffffffffffffffffffffffffffffff","fernando");
		assertTrue(user.MaxUserVal());
		user=new User("30038420","fernando","corinaldesi","fernando","fffffffffffffffffffffffffffffff");
		assertTrue(user.MaxPassVal());
		
	}
	@Test
	public void UsersIgualesDeberiaDevolverTrue() {
	 assertEquals(new User("30038420","fernando","corinaldesi","fernando","fernando"),new User("30038420","fernando","corinaldesi","fernando","fernando"));
	}
	
	@Test
	public void UsersDistintosDeberiaDevolverFalse() {
	 assertNotEquals(new User("30038420","fernando","corinaldesi","fernando","fernando"),new User("30038421","fernando","corinaldesi","fernando","fernando"));
	}
	
	@Test
	public void UsersHashCodeDistintosDeberiaDevolverFalse() {
	 assertNotEquals(new User("30038420","fernando","corinaldesi","fernando","fernando").hashCode(),new User("30038421","fernando","corinaldesi","fernando","fernando").hashCode());
	}
	@Test
	public void UsersHashCodeIgualesDeberiaDevolverTrue() {
	 assertEquals(new User("30038420","fernando","corinaldesi","fernando","fernando").hashCode(),new User("30038420","fernando","corinaldesi","fernando","fernando").hashCode());
	}

}
