package com.nttdata.proxy;

public class PersonProxyClass2 extends AbstractPersonProxy {

	public PersonProxyClass2(IPersonProxyInterface person) {
		super(person);		
	}

	@Override
	public void before() {
		System.out.println("Class 2 before");		
	}

	@Override
	public void after() {
		System.out.println("Class 2 after");		
	}	

}
