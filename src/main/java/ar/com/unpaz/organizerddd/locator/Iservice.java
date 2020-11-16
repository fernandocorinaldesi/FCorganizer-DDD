package ar.com.unpaz.organizerddd.locator;

public interface Iservice {
	public <T> T getDependency(Class<T> key);
	public <T> void addDependency(Class<T> key,T value);
}
