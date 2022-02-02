package com.nttdata.singleton;

import com.nttdata.domain.Person;

public enum PersonSingletonEnum {
	
	INSTANCE;
	
	Person person;
	
	private PersonSingletonEnum() {
		this.person = new Person();
	}
	
	public Person getPerson() {
		return this.person;
	}

}
