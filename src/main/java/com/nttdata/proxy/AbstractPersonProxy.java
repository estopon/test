package com.nttdata.proxy;

public abstract class AbstractPersonProxy implements IPersonProxyInterface {
	
	private IPersonProxyInterface person;
	
	protected AbstractPersonProxy (IPersonProxyInterface person) {
		this.person = person;
	}	

	@Override
	public void operacion() {
		before();
		this.person.operacion();
		after();
	}
	
	public abstract void before();
	
	public abstract void after();

}
