package com.nttdata.proxy;

public class PersonProxyClass1 extends AbstractPersonProxy {

	public PersonProxyClass1(IPersonProxyInterface person) {
		super(person);		
	}

	@Override
	public void before() {
		System.out.println("Class 1 before");		
	}

	@Override
	public void after() {
		System.out.println("Class 1 after");		
	}	

}
