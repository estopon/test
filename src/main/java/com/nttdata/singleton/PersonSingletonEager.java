package com.nttdata.singleton;

import com.nttdata.domain.Person;

public class PersonSingletonEager {
	
	public static final Person INSTANCE = new Person();
	
	private PersonSingletonEager() {
		super();
	}

}
