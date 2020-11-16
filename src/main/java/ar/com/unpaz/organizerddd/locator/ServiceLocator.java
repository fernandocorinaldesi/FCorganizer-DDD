package ar.com.unpaz.organizerddd.locator;

import java.util.HashMap;
import java.util.Map;

public class ServiceLocator implements Iservice{

	private final Map<Class<?>, Object> values = new HashMap<>();
	
	@Override
	public <T> void addDependency(Class<T> key, T value) {
		values.put(key, value);
	}

	@Override
	public <T> T getDependency(Class<T> key) {
		// TODO Auto-generated method stub
		return key.cast(values.get(key));
	}

	

}
